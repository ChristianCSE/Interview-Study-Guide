#Add Binary [Success]
<pre>
Runtime only beats 2.10% of Java Submissions
Runtime: 27 ms
Comps: FB
Tagged: Math & String
</pre>




#Thinking
<table>
<thread>
<tr>
    <th>Data Structure/Other</th>
    <th>Method</th>
    <th>Space Complexity [If applicable]</th>
    <th>Explain</th>
  	</tr>
  </thread>
<tbody>

<tr>
<th>Array & int </th>
  <td> Character.getNumeric<br/>Value(a.charAt(i)) </td>
  <td> This is what is making this extremely slow. The look-up is O(1), but then it seems that <b>Character.getNumericValue(char)</b>
  might be expensive. If not that, then my string traversal that makes both string the same length O(n)
  is what is slowing it down. </td>
  <td> If I want to improve the runtime, then I would make a switch that goes off when I reach the max
  length limit of the shorter string rather than making both string the same length since by doing that
  I am adding O(n) to make them the same length and on top of that I am adding O(lengthDifference) to
  for when I am adding both binary strings.</td>
</tr>

</tbody>
</table>
