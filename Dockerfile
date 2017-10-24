FROM cogniteev/oracle-java:java8


WORKDIR /testserver

RUN  apt-get update \
	&& apt-get install -y python3  \
	&& echo 'alias python=python3' >> ~/.bashrc \
	&& apt-get install -y python3-pip \
	&& pip3 install requests \
	&& rm -rf /var/lib/apt/lists/* \
	&& apt-get clean

ADD . .

RUN python3 scripts/sdk.py build_test_server

EXPOSE 5000

# Run test server when the container launches
CMD ["python3", "-u", "scripts/sdk.py", "launch_test_server"]