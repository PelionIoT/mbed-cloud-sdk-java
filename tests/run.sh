#!/bin/bash
set -e

export DEBUG=superagent
export DEBUG_COLORS=true

export CONSOLE_COLOURING=true
ARTIFACTS_LIST=$(find -name "artifacts.properties")

if [ -e "${ARTIFACTS_LIST}" ]; then
        source "${ARTIFACTS_LIST}"
fi

if [ -z "${TEST_FULL_JAR}" ]; then
	echo "Environment variable not set: TEST_FULL_JAR"
	exit 1
fi

java -jar "${TEST_FULL_JAR}" &
pid=$!

function finish {
	kill $pid
}
trap finish EXIT

sleep 1
python -u testrunner/bin/trunner -s http://localhost:5000
