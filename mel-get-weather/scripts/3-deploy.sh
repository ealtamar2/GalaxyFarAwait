#!/bin/bash
set -eo pipefail
ARTIFACT_BUCKET=$(cat bucket-name.txt)
aws cloudformation package --profile personaluser --template-file template.yml --s3-bucket $ARTIFACT_BUCKET --output-template-file out.yml
aws cloudformation deploy  --profile personaluser --template-file out.yml --stack-name mel-get-weather --capabilities CAPABILITY_NAMED_IAM
