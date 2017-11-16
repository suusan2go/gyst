curl http://localhost:3000/v2/api-docs > tmp.json
docker run --rm -v ${PWD}:/local swaggerapi/swagger-codegen-cli generate \
    -i /local/tmp.json \
    -l typescript-fetch \
    -o /local/frontend/src/api/client
rm tmp.json
