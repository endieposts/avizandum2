To run, this will need the db username, password etc stored in vault. Start up a local server in dev mode

e.g.

set VAULT_ADDR=http://127.0.0.1:8200

c:\Utils\Vault\vault server --dev --dev-root-token-id="00000000-0000-0000-00000000000"

PAUSE



And add a script to store secrets, such as:

set VAULT_ADDR=http://127.0.0.1:8200

vault kv put secret/avizandum2 dbusername=insertusernamehere 
vault kv put secret/avizandum2 dbpassword=insertpasswordhere

Change the username and password values to the actual application ones.

For running tests in dev: add $dbusername and dbpassword environment variables to match values in the test user db

Also for tests in dev: add $awsusername and $awskey environment variables