FROM centos:7
MAINTAINER Edward Yeh "yehwh0222@gmail.com"
ENV REFRESHED_AT 2016-04-25
RUN yum -y install python-setuptools
RUN easy_install pip
RUN pip install supervisor
RUN yum -y install epel-release
RUN yum -y install nginx
RUN yum -y install php-fpm

# tweak php-fpm config
RUN sed -i -e "s/;cgi.fix_pathinfo=1/cgi.fix_pathinfo=0/g" /etc/php.ini

# tweak nginx config
RUN rm -Rf /etc/nginx/conf.d/*
ADD nginx/default.conf /etc/nginx/conf.d/
ADD nginx/nginx.conf /etc/nginx/nginx.conf

# Supervisor Config
ADD supervisor/supervisord.conf /etc/supervisord.conf

# add php info page
ADD website/index.php /usr/share/nginx/html/index.php

# expose ports
EXPOSE 80

CMD ["/usr/bin/supervisord", "-n", "-c", "/etc/supervisord.conf"]
