#Architecture
<br/>
<table><thread><tr>
    <th>8. Architecture </th>
    <th> Explain</th>
  </tr></thread>
  <tbody>

<tr>
<th>  Backend Architecture </th>
  <td>
      <b>Scaling</b>: 
      <br/>Buy commodity hardware. Using cloud storage to expand. <br/>
      <b>Web Servers</b>:
      <br/>Apache, lightHTTP, nginx => These all require httpd.conf. Simpler things like max connections
     , worker MPM, usually unconfig'd <br/>
      <b>Languages</b>:<br/> Languages aren't meant to scale for you. Use bytecode caches (PHP, Python, etc). <br/>
      <b>Databases</b>:<br/> Slow, partition datat into shards and tune database. <br/>
      <b>The above </b>: <br/> A good example of the architecture above would be a LAMP stack. 
  </td>
</tr>
<!---->
<tr>
<th> Questions </th>
  <td>
  <ul>
  <b>How do you scale easily? </b>: 
  <li> Use caches</li>
  <li> Disk based caching [cache-lite via php pear] RAM disks on SSDs. </li>
  <li> In-memory caching (APC memcached). .</li>
  <li> Cloud-based caching. </li>
</ul>

  <ul>
  <b>Why memcache </b>: 
  <li> Fast over networks </li>
  <li> Scales, failover, wide support  </li>
  <li> Centralized/shared across site .</li>
  </ul>

  <ul>
  <b>S3</b>:
  <li> Databases are bad for blob storage. </li>
  <li> Databases are good for relational data. </li>
  <li>S3 = file and data storage that runs over HTTP.</li>
  <li>Centralized and shared across site.</li>
  </ul>
    </td>
    </tr>
<!---->
<!---->



</tbody></table>
