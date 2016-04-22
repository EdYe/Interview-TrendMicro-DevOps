echo run php.yml

ansible-playbook php.yml

if [ $? -ne 0 ]; then
  echo Fail to run php.yml
  exit
fi

echo run nginx.yml

ansible-playbook nginx.yml

if [ $? -ne 0 ]; then
  echo Fail to run nginx.yml
  exit
fi

echo run nginx_php.yml

ansible-playbook nginx_php.yml

if [ $? -ne 0 ]; then
  echo Fail to run nginx_php.yml
  exit
fi

echo run phpinfo.yml

ansible-playbook phpinfo.yml

if [ $? -ne 0 ]; then
  echo Fail to run phpinfo.yml
  exit
fi
