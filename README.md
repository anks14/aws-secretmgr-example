

# aws-secretmgr-example


aws secretsmanager create-secret --name dbsecret1  --description "My test database secret"  --secret-string file:///Users/ankit/aws-secretmgr-example/src/main/resources/secret-create.json

aws secretsmanager describe-secret --secret-id dbsecret1



