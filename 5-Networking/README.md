#Networking
  * Network Layer
  * HTTP Protocol
  * SSL
  * IP Routers
  * TCP & UDP
  * Subnetting Mask
  * STMP & POP3
  * Ping
  * TCP Handshake
  *  <a href ="https://launchschool.com/books/http/read/background"> Browser; what happens?</a>
  
  <br/>
  
  
  

<table><thread>
<tr>
    <th>5. Newtorks </th>
    <th> Explain</th>
  </tr></thread>
  <tbody>


<tr><th> Network  </th>
  <td> A network is a collection of PC's or PC-like devices that can communicatie across a common transmission medium. <br/>
A network protocol; however, is a system of common rules that define the complex process of network communication.</td>
  </tr>

<tr><th> Network Layer </th>
  <td> X</td>
</tr>

<tr><th> TCP/IP Protocols </th>
<td>
SMTP: Simple Mail Transfer Protocol <br/>
MIME: Multi-purpose Internet Mail Extensions <br/>
POP: Post Office Protocol <br/>
IMAP: internet Message Access Protocol
</td>
</tr>



<tr><th> TCP/IP Protocol Stack  </th>
<td>
Application L. (FTP, HTTP, Telnet)<br/>
Transport L. (TCP or UDP)<br/>
Internet L. (IP)<br/>
Network Access L. (Ethernet,etc) <br/>
Each layer is used for a particular connection. Each layer also wraps around a section of the packet.  <br/>
At each layer, the packet consists of two parts; header and body: <br/>
<b>Header</b>: Protocol information w.r.t. layer. <br/>
<b>Body</b>: Data w.r.t. layer.  This usually consists of a whole packet form the next layer in the stack.  <br/>
Each layer treats the info it gets from layer above. Each layer also applies its own header to that data.  Nothing is lost; hence, the packet contains all info passed from higher layer : encapsulation. <br/>

</td>
</tr>






<tr><th> TCP/IP</th>
  <td>
  Network communication process, how a unit of data should look like, and what info it should contain. All of this is so the receiving PC can interpret the message correctly. <br/>
  TCP/IP Standards =/= TCP/IP implementation <br/>
  Implementation: Software components that perform function to enable PC’s to partake in networks <br/>
  Standards: System of rules defining communication on networks. This ensures compatibility. <br/>
  Hence, one can understand that the TCP/IP model does not provide the services for its 4 layers: Application, Transportation, Internet, Network Access<br/>
  Instead the model acts more like an interface, as it defines the service that should be provided, but offers no implementation of said services. Software implementation: The provider of the services. <br/>
  <br/>
  <b>End node verification</b>: 2 PC"s communicaion and they are at the end of the messaging chain. <br/>
<b>Dynamic routing</b>:  Multiple paths and the router chooses a path for the data based on conditions. <br/>

  </td>
  </tr>

</tr>
<th>HTTP Protocol</th>
  <td> X</td>
</tr>


<tr><th>  SSL </th>
  <td> X</td>
</tr>


<tr><th> IP Routers  </th>
  <td>
  IP Routers: IP packets are sent through here; hence, its purpose is to send these packets to their correct destination. Paths may vary, even when being sent to the same end point. It does this by being mindful of : correct addressing, traffic volume, errors in the network, etc. <br/>
  32 bits or four 10-base digits, where each the maximum value is 255 for each. By this it means: aaa.bbb.ccc.ddd each 10-decimal representation can be of value (0-255). In other words each value is represented as an 8 bit binary value <br/>
  We know from binary arithmetic that an 8 bit number has 256 UNIQUE values, but a maximum value of 255. It is also important to note, that each computer has a unique IP value. <br/>
  We currently run on IPv4: 2^32.
  </td>
</tr>


<tr><th> TCP & UDP  </th>
  <td> X</td>
</tr>


<tr><th>  Subnetting Mask </th>
  <td> X</td>
</tr>


<tr><th>  STMP & POP3 </th>
  <td> X</td>
</tr>


<tr><th> Ping  </th>
  <td> X</td>
</tr>


<tr><th> TCP Handshake  </th>
  <td> X</td>
</tr>


<tr><th>  Browser; url? </th>
  <td> A web address is translated to a number by a DNS. When domain names are registered together with a TCP/IP address, the DNS update this information. </td>
</tr>


</tbody></table>
