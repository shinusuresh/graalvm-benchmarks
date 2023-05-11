# graalvm-benchmarks

Spring boot, Quarkus, Micronaut Graal benchmarks

# Installation

sdkman

https://sdkman.io/install

K6s

```
brew install k6
```

psrecord

```
pip3 install psrecord
```

# Running benchmark scripts

> Before running the script, make sure you assemble jars and create native images for each projects.

## JDK

```
./run.sh jdk spring openjdk
./run.sh jdk quarkus openjdk
./run.sh jdk micronaut openjdk
```

## GraalVM JDK

```
./run.sh jdk spring graaljdk
./run.sh jdk quarkus graaljdk
./run.sh jdk micronaut graaljdk
```

## GraalVM Native

```
./run.sh jdk native spring
./run.sh jdk native quarkus
./run.sh jdk native micronaut
```
