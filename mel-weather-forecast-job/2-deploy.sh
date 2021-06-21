#!/bin/bash
set -eo pipefail
ARTIFACT_BUCKET=$(cat bucket-name.txt)
TEMPLATE=template-mvn.yml
mvn package
aws cloudformation package --profile personaluser --template-file $TEMPLATE --s3-bucket $ARTIFACT_BUCKET --output-template-file out.yml 
aws cloudformation deploy --profile personaluser --template-file out.yml --stack-name mel-weather-forecast-job --capabilities CAPABILITY_NAMED_IAM
