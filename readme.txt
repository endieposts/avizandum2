To run, this will need the db username, password etc stored in vault

e.g.
vault server -dev
vault write secret/avizandum dbusername=value1 dbpassword=value2 etc
vault read secret/avizandum