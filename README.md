# vmware-questions
==================

Question1
---------
1)clone latest code 
git clone https://github.com/bairaginath/vmware-questions.git

2) cd vmware-questions/question1

3)test and build this application as below
./mvnw clean install

4)After build Successfully ,Run this application as below
java -jar target/question-0.0.1-SNAPSHOT.jar

5) server will start with 8080 port
curl http://localhost:8080



Question2
----------
2.1Explain the concepts of Default Gateway in IP
 A default gateway is the node in a computer network using the internet protocol suite that serves as the forwarding host (router) to other networks when no other route specification matches the destination IP address of a packet.
 A gateway is a network node that serves as an access point to another network.


 2.2Explain the concepts of SNAT and DNAT.
 Network Address Translation (NAT) occurs when one of the IP addresses in an IP packet header is changed. In a SNAT, the destination IP address is maintained and the source IP address is changed. ... A DNAT, by way of contrast, occurs when the destination address is changed and the source IP address is maintained.

SNAT is typically used when an internal (private) host needs to initiate a session to an external (public) host; in this case, the device that is performing NAT changes the private IP address of the source host to some public IP address.
 DNAT is typically used when an external (public) host needs to initiate a session with an internal (private) host.

2.4 - Explain ARP
-----
The Address Resolution Protocol (ARP) is a communication protocol used for discovering the link layer address, such as a MAC address, associated with a given internet layer address, typically an IPv4 address.

The Address Resolution Protocol is a request-response protocol whose messages are encapsulated by a link layer protocol. It is communicated within the boundaries of a single network, never routed across internetworking nodes.


