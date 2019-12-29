<h1>Server Setup</h1>

Backend is running on port 8080 on remote server on vergo home directory 

Frontend is running on port 4200 on remote server - nginx is serving up index.html + the other static angular files

Nginx config is located in /etc/nginx/sites-enables, file is default 

Any requests to frontend of the form /api/blah are proxied to the server running on 8080, with the "api" bit
stripped out so that the request becomes /blah 

In vergo home folder there is a script called deployServer.sh, can use that to redeploy server after changes 