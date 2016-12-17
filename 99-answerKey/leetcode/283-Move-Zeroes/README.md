#Passed 28 seconds
###Only beats ~8% of other Java solutions




<p>In-place and Minimize operations!</p>

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
<th> Insertion Sort</th>
  <td> The logic followed is from Insertion-Sort with two add-ons.
  <br/>1. I do a check if the current index contains a 0.
  <br/>2. I am not sorting it, I am just moving all the zeroes to the right, while
  maintaining the original order. </td>
  <td> <b>WC: O(n<sup>2</sup>)</b>, via Gauss partial sum
  <br/> <b>BC: O(n)</b>, it's already sorted, but you still have to iterate through the whole thing </td>
  <td> Insertion sort with 2 add-ons of my own.</td>
</tr>
<!---->
</tbody>
</table>



<!-- <tr>
<th> </th>
  <td> </td>
  <td> </td>
  <td> </td>
</tr> -->
