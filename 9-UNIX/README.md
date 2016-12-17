#UNIX

<br/>
<table><thread><tr>
    <th>9. UNIX </th>
    <th> Explain</th>
  </tr></thread><tbody>

<tr>
    <th> Basic commands </th>
    <td>
        <b>< </b>: Read
        <br/>
        <b>> </b>: Write
        <br/>
        <b>|</b> Pipe : This takes stdOut from the previous proces and uses it in stdIn of the next process. Pipes, in the command line at least, are unidirectional.
        <br/>
        <b>grep</b>: grep "what you're looking for" inhere.java => This will then print every instance of "what you're looking for"
        <br/>
        <b>ping</b>: this tests the connection between local server IPC and remote UNIX server. It uses an ICMP (Internet Control Message Protocol) protocol.
        <br/>
        <b>chmod</b>: chmod xyz this_file => <br/>
        (where 0<=x , y, z <=6 ) This allows you to change the access file permissions. <br/>
        X represents the <b>owner</b>, Y is the <b>group</b>, and Z is <b>other</b> where each digit represents 3 bits. <br/>
        In other words, 6 represents 110 or 7 representing 111. <br/>
        Each bit represents a permission: Read/View ||| Write/Edit ||| Execute. So if we do "chomd 666 myfolder"=> we have given Read/Write permissions to the owner, group, and other.
            <br/>
            <hr/>
            <b>Writing to a file via cmnd line</b>: echo 'Hello, World. ' > foo.txt
            <br/>
            <b><u>Std</u></b>
            <br/><b>StdIn</b>: 0
            <br/><b>StdOut</b>: 1
            <br/><b>StdErr</b>: 2
            <hr/>
            <b><u>More UNIX</u></b>
            <br/><b>Terminal</b>: Text input and ouput environment.
            <br/><b>Shell</b>: Command line interpretator
            <br/><b>Console</b>: "Physical" terminal
            <hr/>
            <br/><b>Coping a file</b>: cp filledfile.js copyOntoHere.js
            <br/> If the copyOntoHere.js DNE, it will automatically be created for you.
            <br/>
            <pre><code>  echo 'var i = 10;' > dummy.js
  cp dummy.js cloneDummy.js</code></pre>
  <hr/>
  <b>If we have a 32-bit machine, what's the largest # possible?</b>
  <br/>
  <b>Answer</b>:
  <pre>
Logic:
2-bit => 11 => The largest possible binary number we can get is 3.
3-bit => 111 => Largest possible is 7.
There is a pattern which is: [(X-bit) * 2 ] - 1 === 2<sup>x</sup> - 1
 Hence, max(32-bit machine #) =  2<sup>32</sup> - 1</pre>
 <hr/>
 <b><u>Kill Switchs</u></b>
 <br/><b>SIGUP</b>: 1; Hang up detected on terminal or death process.
 <br/><b>SIGKILL</b>: 9; Quit immediately with no clen up.
<hr/>
<b><u>Important Ports</u></b>
<br/><b>HTTP</b>: 80
<br/><b>HTTPS</b>: 443
<br/><b>SQL Server</b>:  156
<br/><b>Echo</b>: 7
<br/><b>Privileged Ports</b>: 0 ----> 1024
<hr/>
<b><u>DHCP/BOOTP packet</u></b>
<br/>
<pre>
  ipconfig getpacket en0 : For ethernet connection
  ipconfig getpacket en1 : For ethernet connection
</pre>
Prints to standard output the DHCP/BOOTP packet that the client accepted from the DHCP/BOOTP server. This is useful for checking what server procided and whether values are sensible.
<br/><b>BOOTP (Bootstrap Protocl)</b>:
Computer networking protocol used in IP networks to auto assign an IP-address to network devices from a configuration server.
<br/><b>DHCP (Dynamic Host Configuration) </b>:
Standardized network protocol used on IP netorks for dynamcially distributing network configutarion parameters like: IP-address for interfaces and services.
<br/><b>Returns</b>:
All the following IP's: client, yours, server, realy. Also, it returns the client ethernet address, subnetmask which is the internet control message protocol, router, and domain name server.
<hr/>
<b><u>Explain what happens when you do a search on your web-browser</u></b>
<br/> <b>Answer</b>
On your PC, through a client machine -- aka your web browser -- you go on google's IP address (72.14.204.147). Your PC will llook at the address and make a TCP connection with the address and make a TCP connection with the IP address at port 80 from the internal IP address using some random source point. The thing that translates the web address into an actual IP number address is the DNS (Domain Name System).
</td>
</tr>
