#!/bin/sh
run_option="${1}"
library_option="${2}"
jdk_option="${3}"

if [ ${run_option} = "jdk" ] 
then
    . /opt/homebrew/Cellar/sdkman-cli/5.16.0/libexec/bin/sdkman-init.sh
    case ${jdk_option} in
        openjdk)
            sdk use java 17.0.5-tem
            ;;
        graaljdk)
            sdk use java 22.3.r19-grl
            ;;
        *)
            echo "Not defined"
            exit 1
            ;;
    esac    

    case ${library_option} in
        spring)
            java -jar ../spring-graalvm/build/libs/spring-graalvm-0.0.1-SNAPSHOT.jar & 
            export APP_PID=$!
            ;;
        micronaut)
            java -jar ../micronaut-graalvm/build/libs/micronaut-graalvm-0.0.1-SNAPSHOT-all.jar & 
            export APP_PID=$!
            ;;
        quarkus)
            java -jar ../quarkus-graalvm/build/quarkus-app/quarkus-run.jar &
            export APP_PID=$!
            ;;
        *)
            echo "Library not defined"
            ;;
    esac      
elif [ ${run_option} = "native" ] 
then
    case ${library_option} in
        spring)
            ../spring-graalvm/build/native/nativeCompile/spring-graalvm & 
            export APP_PID=$!
            ;;
        micronaut)
            ../micronaut-graalvm/build/native/nativeCompile/micronaut-graalvm &
            export APP_PID=$!
            ;;
        quarkus)
            ../quarkus-graalvm/build/quarkus-graalvm-0.0.1-SNAPSHOT-runner &
            export APP_PID=$!
            ;;
        *)
            echo "Option not valid"
            ;;    
    esac
else
    echo "Not all parameters are passed."
fi


psrecord $APP_PID --plot plot-$run_option-$library_option-$jdk_option.png --interval 1 --include-children &
export PS_PID=$!
sleep 5
echo "PID - $APP_PID"
echo "Applying load"
#siege -b --concurrent=50 --content-type="application/json" 'http://localhost:8080/users' -t 30s
k6 run --vus 100 --duration 30s --out influxdb=http://localhost:8086/k6 scripts.js
sleep 5
echo "Stopping $APP_PID and $PS_PID"
kill $APP_PID
wait $PS_PID