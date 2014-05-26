import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.SortedMap;
import java.util.TreeMap;
public class FrequencyCounter
{
public static void main(String[] args)
{
int minlen = Integer.parseInt(args[0]);
// key-length cutoff
ST<String, Integer> st = new ST<String, Integer>();
while (!StdIn.isEmpty())
{ // Build symbol table and count frequencies.
String word = StdIn.readString();
if (word.length() < minlen) continue; // Ignore short keys.
if (!st.contains(word)) st.put(word, 1);
else
st.put(word, st.get(word) + 1);
}
// Find a key with the highest frequency count.
String max = "";
st.put(max, 0);
for (String word : st.keys())
if (st.get(word) > st.get(max))
max = word;
StdOut.println(max + " " + st.get(max));
}
}
