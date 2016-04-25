FROM centos:7
MAINTAINER Edward Yeh "yehwh0222@gmail.com"
ENV REFRESHED_AT 2016-04-25
RUN yum install supervisor
RUN yum install epel-release
RUN yum install nginx
RUN yum install php-fpm

# tweak php-fpm config
RUN sed -i -e "s/;cgi.fix_pathinfo=1/cgi.fix_pathinfo=0/g" /etc/php.ini

# tweak nginx config
RUN rm -Rf /etc/nginx/conf.d/*
ADD nginx/default.conf /etc/nginx/conf.d/
ADD nginx/nginx.conf /etc/nginx/nginx.conf

# Supervisor Config
ADD supervisor/supervisord.conf /etc/supervisord.conf

# add php info page
ADD website/php.index /usr/share/nginx/html/index.php
RUN chown -Rf www-data.www-data /usr/share/nginx/html/

# expose ports
EXPOSE 80

CMD ["/usr/bin/supervisord", "-c", "/etc/supervisord.conf"]
