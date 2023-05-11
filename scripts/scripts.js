import http from "k6/http";
import { check, sleep } from "k6";

export const options = {
  stages: [
    { duration: "5s", target: 30 },
    { duration: "10s", target: 80 },
    { duration: "15s", target: 100 },
  ],
};

export default function () {
  const res = http.get("http://localhost:8080/users");
  check(res, { "status was 200": (r) => r.status == 200 });
  sleep(1);
}
