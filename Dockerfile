FROM cogniteev/oracle-java:java8


WORKDIR /testserver

RUN  apt-get update \
	&& DEBIAN_FRONTEND=noninteractive \
	&& apt-get install -y python3  \
	&& apt-get install -y python3-pip \
	&& apt-get install -y python-setuptools \
	&& apt-get install -y iputils-ping \
	&& apt-get install -y git \
	&& pip3 install -U pip \
	&& echo 'alias pip=pip3' >> ~/.bashrc \
	&& echo 'alias python=python3' >> ~/.bashrc \
	&& rm -rf /var/lib/apt/lists/* \
	&& apt-get clean

ADD . .

RUN pip3 install -r scripts/requirements.txt

RUN python3 scripts/sdk.py build_test_server

EXPOSE 5000

# Run test server when the container launches
CMD ["python3", "-u", "scripts/sdk.py", "launch_test_server"]