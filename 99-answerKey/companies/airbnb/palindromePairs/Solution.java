import java.util.List; 
import java.util.ArrayList; 
import java.util.Arrays;
import java.lang.StringBuilder;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.HashMap;
import java.util.Set;
import java.util.LinkedHashSet;

class Solution{
      /**cases:
       * 1. already a palindrome => can only stay a palindrome if "" blank exists: This would be bidriectional
       * 2. the reversal string that would make it a palindrome exists, this would
       * be bidirectional!
       * 3. Rares: ssl this would require ssl + ss to become a palindrome that means
       * we need word(leftcurrent) = > map.contains(currWord.substring(0,2)) ls => would imply
       * */
   public static List<List<Integer>> palindromePairs(String[] words)
   {
    Map<String, Integer> map = new HashMap<>();
    int len = words.length, i; 
    List<Integer> pair; 
    List<List<Integer>> listOfPairs = new ArrayList<>();   
    Set<List<Integer>> noduplicates = new LinkedHashSet<>();
    for(i = 0; i < len; i++)
    {
      map.put(words[i],i);
    }

    for(i = 0; i < len; i++)
    { 
      String currWord = words[i];

      if( checkDrome(currWord) )
      {
        if( map.containsKey("") )
        {
          if( i != map.get("") )
          {
            //frwrd
            pair = new ArrayList<>(2);
            pair.add(i);
            pair.add(map.get(""));
            // listOfPairs.add(pair);
            noduplicates.add(pair);

            //bkwrd
            pair = new ArrayList<>(2);
            pair.add(map.get(""));
            pair.add(i);
            // listOfPairs.add(pair);
            noduplicates.add(pair);
            
          }
        }
      }
/*
      //does the string that'll make this a palindrome exist?
      String reverse = new StringBuilder(currWord).reverse().toString();
      if( map.containsKey(reverse)  )
      {
        //takes care of unique
        if(i != map.get(reverse) )
        {
            //frwrd
            pair = new ArrayList<>(2);
            pair.add(i);
            pair.add(map.get(reverse));

            // if(!listOfPairs.contains(pair)) { listOfPairs.add(pair);}
            noduplicates.add(pair);

            //bkwrd //don't need will be done later
             pair = new ArrayList<>(2); 
             pair.add(map.get(reverse)); 
             pair.add(i); 
            // if(!listOfPairs.contains(pair)) {listOfPairs.add(pair);}
            noduplicates.add(pair);
        }
      }
*/

//Even if the word is already a palindrome, it can still
//be concatenated and still be a palindrome
//aabb => aabb + aa => aabbaa
      int wordlen = currWord.length(), j;
      for(j = 1; j <= wordlen; j++)
      {
        String leftPointer = currWord.substring(0,j);
        String leftReverse = new StringBuilder(leftPointer).reverse().toString(); 
        

        if( checkDrome( currWord+leftReverse) )
        {
          if(map.containsKey(leftReverse))
          {

            if(i != map.get(leftReverse))
            {
              pair = new ArrayList<>(2);
              pair.add(i); 
              pair.add(map.get(leftReverse)); 
              // listOfPairs.add(pair);
              noduplicates.add(pair);
            }
          }
        }

        String rightCurr = currWord.substring(wordlen-j,wordlen);
        String reverseRight = new StringBuilder(rightCurr).reverse().toString(); 
        if(checkDrome(reverseRight+currWord) )
        {
          if(map.containsKey(reverseRight))
          {
            if(i != map.get(reverseRight))
            {
              pair = new ArrayList<>(2);
              pair.add(map.get(reverseRight)); 
              pair.add(i); //still use i, not j 
              // listOfPairs.add(pair);
              noduplicates.add(pair);
            }
          }
        }           
    }
    }
    listOfPairs.addAll(noduplicates);
    return listOfPairs;
  }

 public static boolean checkDrome(String concat)
  {
    if(concat.length() == 1 || concat.length() == 0) {return true;}
    int len = concat.length() - 1, i; 
    for(i = 0; i <= len/2; i++)
    {
      if(concat.charAt(i) != concat.charAt(len - i))
      {
        return false;
      }
    }
    return true; 
  }




  public static void main(String[] args)
  {
    // String[] tester = new String[]{"aa", "", "hello"};
    //System.out.println(Arrays.deepToString(tester));
    // System.out.println(palindromePairs(tester));
    String[] wordList = new String[]{"hf","ec","gdb","fabgjafbf","af","agecbbjjeeideih","ghfhhahgcibffhggh","fhichih","cibafefjagdffc","jghehbbiadh","dccagjhieg","aibghiehhcchdafif","fgahfbiihe","adgdfhadcdjjfccaghg","fgjjfhehgaiiciiejdbc","abbicii","ce","hagfddhaej","bgcijbefe","bdg","ajjjeafggbadecfahih","ijahchhcfbggefafbgf","iaadcgeifef","bifib","adbehigfebh","ddeaajihjbgfdd","dcfaaecdgbi","gcj","dfihgia","dgcafeb","gfbiccffdifhhfhhi","fahjiiihhfciegjedhd","jiaihbgabigbdbdhdd","iifgebdejddabagjhcde","hhdgffjdfeafajdee","cjgajaheafeie","fhdgejcbcbdcjiffgd","c","ibd","ieccgebahaffhegdgdd","dahf","ddjfhfeejecibj","bbaeicdaageecchje","ajcbfchhfbfefbfhdigj","hbcjfjdiicae","daddfeaafhdah","bifdjadabicajfcejfb","gidjdcibehaicejjcf","eeahejajehcfigjcdf","dhgejaiheejjaadegfja","jibfccdcjg","dcafcddjcabccjhjgig","igciaeiidfdhcgbaihbe","gfcbfiibjcj","fecdidih","aeidfgajf","abei","hidafgiddehebfdhhcdd","jcijc","fffcfbehgbjfeife","jbgcchhie","jfejdihgggdjijjbeicj","cjifjecba","bebccecddbiicaibfi","cjjfhjacbbbc","abiddgdiicfhfddfbc","fjgedbhjeeaj","aeiadic","ab","igfhhjeajb","ijdhgiifaedehch","ffibcidf","fgiajcbifgc","ceddacdjdacjdjjgei","ieai","bfejge","ejfhicdd","bbgjbajjdjheifeghjee","fifhhdcebbbjg","ecbhdebc","hejffcfbfchahcdigh","ibffjacdhebe","cebjc","adfijhejc","ebjfeaffbcbhdcdgebch","eaced","fheafdbec","iabibeag","habhfbdddjeja","fehbhbieggdgdhbicfj","efifjbacce","jgedceifggdbbfjiea","egbdcjeage","jajhifj","fiiafcbjd","gjhd","ecbcb","jcihjcbdc","h","jcf","gdbdgihceeiifhida","aeihfhhhiheiigej","ifcbjedfhafgjg","cgif","fadfjdagbeiejhegf","faigdcfdihibighgf","ihfjjigahcfja","daeibjcahjdbeae","chebcefiibbgd","cdbejafihg","ibfhjbejggajgdhebaeg","d","fbjhdfciceibfiabjfd","ggeid","hhehi","cjfbah","igbgjaiciddfif","hejgbi","cifibde","aiecbigeddjfge","hbifcghbababhjib","gie","jjaaihhdcdba","dcfigdiaghiheegf","defdj","cddibiiicjefggdefi","ehfhh","bdhbgddgabghea","jbjhachejcj","ccedf","efehbbjhgg","ifahaiciajfeegfa","ae","cdcfgfbceb","jdgbhcgdhgjfbaegcfd","ja","bebdi","fijdicf","hjbjdddffggjjdihdj","adaih","idbijgeaaiadeeijgcaj","eadcejdi","cdghfgiijga","afiibdfjgdfde","ig","fbciifeh","cfdfggfgceaccddd","bgfifjdei","eddccajdbihbbejjeije","addidedafiihb","ahagfcagbjah","cjjhhjjidhceiai","geb","jecciidjjfabaccecd","a","behii","accihhe","fjd","jbfa","giia","ag","cgfjhdgdfedcijghih","bdabic","gjafha","aibihaafghjifhdeicdj","ejeibaegbddjeheiied","hcjgfdjfcgbbedeaea","gdcceceihgbej","fdf","idhfefebb","ecdijjhgdaaafg","agecicdfibe","fggecagdbbgh","gbfajfeaac","hdgfgacdaf","ciifbjbhcafbhib","gdeebgfe","heicafbahdad","hggiebcihdj","hbieegcihddfeghfca","jjcgchjf","hbjbcdghiaghcag","gdaiaibcjafgfciecib","fhfjacgficbdej","fgdfghabijjdbfi","f","cfbcihbejgcacj","cg","hecfdhdd","hbddgfddiieffjjbcjcf","iifjcgji","daafbhjjdaagcibhjihi","gab","jaefjcgja","fedbbhddgdf","fidb","aahifcfbfcedgihehe","ajaifgiai","fdcjdfdhgecdebjifjc","cehhbcag","acdefjjh","bihdfaafbfffhd","hhfehjgjb","febghhd","jidji","fab","ggcfdhae","bdbgiijabieij","hddajcfbbfijhaigh","fedfjbe","ddbjbdai","jfjjbbefgbecjcbhjdce","ijefg","jeeagddbjjadeaeddhe","ghideebj","jheibcjgaecfhdceea","ee","gcdfccegcedie","igbbfc","ifeedefcjbb","fbgdh","fbdg","adecjdicgcgheaiaddie","jgeaafgcfjchb","babcefcgjjfj","fhhdhecejecej","hagejedjeagaiij","bbgh","i","aeedcebhhbhjhejcecje","jcei","bjibedbaaiabebddidfi","jgdibeaicfcficiie","gbeihefaeehgafajic","eah","efaica","fcfea","ebiabbed","hjied","ahbabafaffeiebd","bjbfdbahecjffefhbeci","aef","hgjbffjhgcj","hfgeidfd","hdcjihbfhfahji","hhjabhagggjjebbicife","cdcdhfaagcg","bcaaca","abheebfafbfighcjife","edhiebbgfijfgidb","ch","bgjfcdicfa","jcijecgeghigb","jeafbj","dbhgafgfeaefg","bcajgjgbb","adjaacefbjbhbhib","bfjcdh","eecgccea","fca","bihghh","bjcafgcejhja","iagfeiebahjbhh","cdfgjabhhdhcji","jcgdadfba","afcgdefhhhfbg","chdicdaehdgidj","bjifiijhjigede","afichgcejffhgjgfbef","dcagbcfijdifafhhdfhe","ib","jhab","dfgjbgideidajagad","hfj","dhgg","cdefjd","echeehdegjfhhgf","gjcii","jb","edbfhj","gfehfiiicijcdjiadihf","ffhgdgdbhcdgheid","fidcdjibhgbj","bdhjebdghfjbggb","djfbgaejch","ejbhjhbhjahfeeh","hgddddfdcjcb","eeiigfjcd","cgbabdeefebgacbgb","afafdhhijcafj","hdh","cejbjdifaedg","iaajifaffhhccieibdca","bbijccjfdcbg","gbbceaihabfcabi","bdgjhijdgbcccdif","efehcicaeh","abdc","iadgibgga","ibbd","iicgbaehddi","ffdajgbag","chcbahdjbha","bfhdccfjcdejag","gbaecjchcjh","ei","ieafiahcje","fgbfhgah","iieddjbhj","jeehjfcfgf","gggaajijieeagaee","edagbf","acha","eijccgg","iiehcbadgccc","cjghbffbjdahjfddgj","bghbebjabicgchicca","iecdcjhajifbhgddjhf","dejabgeiaihjecbgaeea","gdefhacefidecdfjieg","aebbge","ciabbjhadibceajgjg","fceadfchgafgag","ebbcgdcdei","jgahhgbhahcja","fhgjaaddij","fjdacaidaagh","eihdcdh","eibiachhacjjigieeb","haecjjhcigicbeadjd","ecgjciaiehaeacdga","geijahc","cjhfaihjdhacfjacg","chjdibjgfece","bag","aeehg","chc","bagffgjhcgagjdi","hhefbjdegibacebcbbe","hbbjaddidjjdi","jcafdbhdh","cgjegied","ebegj","ffhgagdhcggdhaja","cdgabebej","bcajheibhffdbg","gja","bidfdfgagacci","jdaebaieee","dbceachijhfdhahcaci","bcjaaiejgggehchjggab","beaggcaijcigjfi","cacgagihjfhbaeiff","eiiheahddbicadfgce","iejd","bc","dfgdfgegdhcgbeb","cihj","acbcahhhcah","bdafhiddcaagadgfbf","ecfjfcbdfigcacicec","dbficdeiicfcj","jiffh","ggda","bihhahdgdifb","ebbdgiefgcjccddb","ddfhaahbjgc","cjcdbjgjdcfh","hjgbj","jdicgbf","jbffidccbjeb","dhdhb","cfecibedghhdgecififf","iihidabiiea","gchdigifg","adjjehahgdd","bfhcdhcciajegaicaa","hfcicjhdgbfgcghd","cebcdagjhhi","fjbcabdef","fhafdecggfbgbcbbgbc","aa","gafahccgiaciba","ffjjajibidgfc","acdbfecdhagd","eegcdahb","eadeigaicgd","jhfjhajiigici","gej","jjchgfafbfdhiah","jcjji","hjicjjeeej","hibbgdifhifh","chgicicdifc","aafjagiebgcffe","hhhbcgfhdifd","hcaachhaddjjc","hdfb","cedcijifiajdfeejffcc","hadgaddcgfjjdejg","ciic","dd","beabcjcjghdjhiih","cajiahjjjbeadee","cifieedh","idaf","ahadgeej","ebehchcibi","djgfdggbejfbjiefe","icf","gfeebgcbhehcggchh","djjccecee","abibjgaidbac","ebg","daijgeda","gfcfhbef","dchjbaf","afhci","adgbgjaiehdabjdhccf","iadcagjfidejca","ebdj","fffdahhbgiibbihfjgc","ahcbadgefhfagd","hd","iibiajf","efifbhhibcac","eacifihidejbeiag","fg","cdffebjj","icehdjddghachhfba","biigd","fecghdgfjjbici","fii","bhafjbjddeibg","bffie","djbfageghjgeadeie","cj","fcaehege","fib","gehaed","b","iicgfffdfj","afahdb","bbedbjfgaeajaai","gfeeedh","fddffbijjdafdgj","hgibfjifhcdhg","caibiaaajh","fhigfcgbhga","cicb","dbfag","bahfdigaejahhbejdbd","edeeahedjcgabcifia","hghciecdhh","aecdicgagbdbeeiacch","adbeicbgh","eagb","baceeaeafceejjidaje","ghdbfeadd","eaedhabcaed","ihcag","jbgbjcjeeafgjheec","g","eddfjgeijfbeff","eaegjcdjggidjcjdaa","gcjabadahbefgjcejgd","gfcciihfjb","gfiijcibgjhbaidaga","jihjfecfhiiaaeheghdg","bja","afjecfhce","dhfccadie","j","jgjhbjgjdccea","eehfdcidafei","gfcgbfeaagfga","djcaajabfbfadbacffbd","ajcibibbdjdbdaffagad","cbdjiagf","acgehdejfajbgcgifhj","hjba","jehhicaigbdh","ajihajgfef","egfafhbcebeedghadh","caif","geeidffbh","jadceg","deefjjhafghb","dfe","aajgadf","jdebahhedge","bdbgdiebjdggjfecfdi","eaigijfigebcfgagg","jfeafdeea","adbhhghjeedjcfejhe","ccfaaag","ifcijbfiahihegighbj","fbfeeeibbbga","aeighbjaafagef","acdgjdbighdeee","cdfhcdahfbdcdchhhfi","bcdidgidjijdeifibjcb","hhcdibhdfa","jebecgbafaehdiddc","bdfdajeaghhgdhj","ebii","hcgagchgh","cifaedibfb","cabbfijecbgdggddhbe","heabh","hdd","afc","cbcbjcbcih","adebiadchcdfchdg","babhfifijhbahgdhdgea","adbicjhhcj","jaf","fbgea","jdi","hbdcejbcccjcid","dbdc","afhbechbgjhffgfcejh","aegcgfiigd","chgifie","bdffhjcjchfegiid","cbfa","jee","gaaaifcjhhgdbbc","jhhc","ef","dbfdfiiiafdibhbecj","aicagb","fcb","bjahfccccajgj","cdjdbghjiafbbbedegbh","jbgacdjfi","ahfgeaebcggc","iefje","deajed","bia","fb","cdeefbbfajhbfbdij","gdbjfcgajdabjafaf","hciaajjf","hccbhcgihaciegdhig","eidhjacfdgh","fbcgaggeigihdi","jjecehghajj","difhdajbegbfegij","ghgigbaac","eiiififiechceajcj","jejghgiabcf","jajba","ecdd","ggfiafjhddhjhiegbfj","igdgceegjegiajhihga","ajjafdheac","iehchdfaaajhjhbdfgg","fiea","dghad","deichgfgjheagjbgib","gf","eegdhdaaaih","baecjgafadjbbbbe","aibeefbi","ejjdhaecbia","cfdjjhiheggehcefgbed","fafcab","bfjfgdeg","agiahejecbhafigfg","jhicieajhibffggfg","dfgejbag","djgacicjbgbdd","hifabjhfj","ecgeehiiaffagfchch","ddgjhcdaeheghjdhj","dadjgijgiagjfiahgdjj","hgcdifdaghab","eaabdeahe","dhgdfbgbedcjdhijfhb","hcj","fjchcjjgeifg","fachbidaebjbbe","idaiccj","ebbedabhibbi","egcecjdebhcjffb","haaedahgjfbdd","hahagjigc","fgghffd","djhcic","fgcdcechfe","iiagciehefaejb","ahhc","hchejafjdeccfb","ca","jbjeiiehjg","fbibfcf","gdfdfefcgbahjd","idbjadeehfdfjjaggd","bjdhbdcecddgcgdi","jcgajbggg","adhfjhibghjihhaef","ifb","gfe","ahgdcfdbededbfffa","acbhacecd","idhgeiicedjeiebhfff","efbadcffbgcbaefcede","gjhdjjibfea","aehebcjaafbccaj","dfgigcg","jejj","acec","hhbjejfbdbdci","chhijedfgfaihcaibji","e","icjfeigaah","ahjjffhgidb","icfjegaebbjhdaf","fdeeaii","djbdbajjiigifcb","hajdjcjg","bghcefiaf","bd","egigicbehgdfegj","gejebachcbidcgid","afcfdifjgahaddieh","gjfddibcjbgg","bgaeccgfdeghicegb","cjgdjieigbijhacceaj","hcdj","ccedeaffc","bdcdgghehj","hicifijjgecibaheibg","hbahhab","chfdbcdaghf","dgfacjdcfbegjceh","gbaeaddggacdf","icdjaihfidcabfedecff","efjagfhcefdhh","jbgfggjehggefcb","aiejjhcjdife","hj","hefdhcgcbfdcbcaagb","jcbdbdghb","iadib","iaddebggjhcdgaccii","gfehdhbaaahdage","gdhfid","ehhbfgfjcdihhbjjgiii","dcgbbcibidedicfbfe","eadgciaidadeibbcbhj","gabaaice","iahdacfabcgb","dhffdgjbj","jeccccgddcabbaihca","hadacidiajgg","fbeabgcfecb","ebgaefed","gceciecbibc","bhcfdbeccgeaichfgj","bgacgbgih","daegfeaecdiahejaedj","aj","ihjadcdjfec","jh","cchfcegfhhca","gacjcdhafa","becabefhiiifjiebaie","cebjhbhhhh","ddgedfjf","ajgdabhjigibfjf","aefehechbhbeegefjd","cafih","ffeehbgdjicc","hdgaeeefaebjijicjhi","ghbbccibjgddcgaihai","hhbaheb","cfijdeideaihaji","gecicjefbchga","iafbbcjcjhafabea","badifh","gajbbgieajge","jbcg","gedddjchbbeahgb","hcigihiaf","fcfgahjcia","bbhchj","jcabgffgejgajfigb","cjgaddg","dgecgcfejhci","fjabagffj","gacdf","fefichheaehehbeja","fdijhacecbbdfg","ajidh","egjbgfji","hibefecgdeeaaa","eijaahdfbbdgjhchhjjd","gfc"};
System.out.println(palindromePairs(wordList));
System.out.println();
    String[] setFail = new String[]{
      "bbaabaaaabbbbaaaabaaaabaabbabbbaaabbabbbabbaaababbaabbaaaabbbaabbaabaaaabaaabbaabab","babbbbbaabbbaaaaaabbbbbbbaabbabbabbbbbaababaabbabbbabbbbbbabba","bbbbaabbbababbabbbbabaababaabbaabbabaaaaabababbabbabbbbbabbbbaaaabbabbabbbabababbbaaa","ababbbbbbbaaaabbaaababbbabababbaabbaababbbabbbabaabbaabaababbbabababaaabbbbabbaa","abbbaababaaaaabababaabaaaaaabbbbbbbababaaaabaabbbaaabbaaaabbbabbbbabbaaaaaaaaaaabbaaaababbabbbabbabaaaaabbaababbabbabababaaaaabbabbababbaaaabbbababaaabbaaabbabbaaba","aabbaaaaaaabaaabbbababbbbabababaaabbbabaabbababbaabbbbbaabbbbaabaa","abbabaabbaaaaaababbbabbabababbababbbbaaaaabbbaaabbaababbababbbabbaaaabbabbbabbabaaaaaaabbabbbaababaaaabbaabaabababbaaaababbabbbabaabbabbbbaaaabbabbaabbaaaababbbbbbaaaaaababba","abbabaabbabbabbbabaabbbbbabaabbbbaabaaabaabaaabbaaaaaaababbababb","bbabbbbaaabbbbaaababbabaabbbbababaaaabbaaabbbaabbbaaabaababababaaaaabbbbaaaabbbababbabbbbaabbbbaaaaaaaaaabbabaaabaabaaa","aabaabbabbabbaaabbbbbaabbaababbabbaabbabaaaaaababaabaabbaaaabbabbbaababaaabaabbbbbaabbbbabbbbaaaaabbbbabbbbabaabaabbaabbbabaabababaabbaaaaabbabaaabbaabbbabaaaababbabbbababaaabbaa","bbbaaaaaaaabaababbabbabbbb","aabbaababbbbbbbabbbababaaaababbabaaabbaaaaabbbaaababbaaabbaaaaaaabbaabbaababbbbaabbaababbabbbbbbaaabaaaabbaabaababaabaab","aabbaabaabbabaabbbababbbaababbaaaababaaaaabaaaababbabbabababaaaabbabbbabbbbbbaababaaabbbababaabaaaabbbabaaa","aabbbbbbaabbabababbbbabbbbbaabbabaabbaaabbbb","ababbabaaabaaa","babbaaaaabbaaabaaaabaabaabaaabaaaaaaabaaabba","bababaabbaaaaababbabaaabbbabababbbbbabbbbababb","aaababbbbaabaabaaaabaabbabbababaaaaab","baabbbbbaabbaaaaababbabaabbabaaaabbabbbaabbabababababbaabaaabbbaabaabbbabbaaabbbbabababaabaabaabaabbbaaabaaabbbaaabaaaabbaaabbaaaababbbbabbaabbababbaabbbbbbababaaaabbbababa","baabbabaabaababbbaababbbbbabbbabbaaaaaaaabbbaabbaabaabbbabaabaabaabbaaabaaaabaaabaababaa","bbabbbabaababaabaaabbbbaaaaaabbbaaaaaaabababababbbbababbaaaaabbaabbabababbaaaabababbababbabbababbabbaa","aabbaabaabbaaabaaaaaabaaabbabababaaaabbabaabaaabbbabababbaabaaabbabbbbabbaabbababbbabbaaaabaaababbabbbbbbaaabbaababbabaabaaabaaabbbabaababaa","babaaababaabbabbabbbbbabaaabbaaabbabaabbabbabbbaabbbaaaaaabaabbaababbbbaaababbababbabbbabaababaabbabababbbabaabbbbaabaababbaa","bbabbababaaababababaabaaaaaaaabaababaababbabbabb","bbabbbbabbaaaabaabbbbbbabbbaaaaaaabbbbabbaaabbabaabbabaabbbbbbaabbbabaaabbabaaabbaba","baabbbbbbaaaaabbaabbbbabaaabbaaaabbbaaabbabaaababaababbbbbbabbaabaaabaaabbabbabaaaba","bbbaabaabbabababbaaabbaaaababaabbbbaabaaaaaaaaabbbbaabbbbabbbabababbabbbbababbaabbba","aabbbaabaababaaaabbbbabaabaabaaabababbaabbaabbaaabaababaaabbbabaaababaabbaababbbbaababaabaabbaababbababbbbbababababaabbabbaabaaaaaabaabbaabaabaaabaabba","abbabaababbbbbbaaaaaababbaabaabbaabbaaaababaababaabbbbbaaaabbbabbbbbaabbbbbbaaababbbaabaabababb","bbbaabaabaaaaabaabaabbbbaaaabaabbbbbaabbaaabbbbbababbbbabbaaaaabbaababababababbbbbbbaaabaabbbaaaaababbbaabbabaabababbbbaaabaabbababbbaabbaabbbbaaaabababbabaabbaaaaaababaaaaabaababaabbabaabbabababab","babaabaabaabbbabaaaabaabbbaaaaaaabaababbabbbaabbbabaababbabbaabbaaabaaaabaababbabbaababbabababbbabaabbbababbbbbbbaaababbaaaabaabaabbababbaaabbaabbbaaabaabaaaabaa","abbbababaaabbaabbbbabababbaabbaaaabaabaabbbbbbbbaabbbbaaaaabbbbabaaaaabbbaaaaabbbbaaaaaababbbbbaabbabaaaaabbaabaaabaababbabaabaaabbab","babaabaababababbbbabababbbaabbaaabbbaabbaaaabaaabbbbbaaaab","aaaabbaabababbbaa","bbbbabbaabaabbbbaaaaaaaabbaababaaabaaabaaabbbbaababbbaabaabbbbaaabbabaabbbbbabbbbaaabababaabbaaababbabababbbabbabaabaaaabbab","aababaabaaaaaabbabababaaaaababbbbaabaa","bbababaaaaaaaaabaabbaaaabaaaaaaaaabbbabaabbbbbabaabaaabbbabbbabbbaaaaaabaaabbbbbbaa","abbaabaaaaabbaaaaaabbbbabaabbabbaabbbabbababaabaabaaabbababbaaabaababbbbbabbbabbabbaaaabbaababbaababbbabbbbbbaaabbbbbbb","baabababbbbbaabbbabaababaababaababbbabbbbbababbaababbaaaabaaabbbbaaaababbabbbabaabaabbababaaa","abbaabbbaabbabbabbbbbbbabbbabbaaabbaaababbaabbaababab","bbabbabbbbbbabababbbabaabbbaaaabababbaabbbabbbbaababbaabaaabbbbabaaaabbbabbaaabaabbaabbbaaababbaaaabaabbabbbabbbaaabaaabbbbabbaabbaabaa","aaaabbbabbaabbababbabbabaababbababaabbaaabaaaababbbabbaaaabbbbabaaabbbaaabababbbabbaabaaabbaabbbaabbbbaaabbbaabbbbababaaaaababbbabaabbbbbbabbabbbbbabaaabaaaaaabbaa","babaaabaabbaababaaabbaaababbbbbbbaabbbbbbbbabbaabbbbbbaaaaabbaabababaabbbabaaaaaaabbaabababaaabbabbabbaababbaaabbbaaaababbbbbabbbaabbbaaaabbabbaabbbaababbaaaabbaaaababbbbbb","abaababbaaabbbaaaaababaabbab","aabbaaaababbbabbbaaabaabababbabbbaabaaaabaabaaaabbabaabbaaabbbaaabbaabbabbbbaaabbbababbaabbaaaabbbabaabbbabbbbbbbaab","aabbbabbabaaaaabbabbababbbabbbbbbbbaabbbbabbbaabaabbaaababbbaaaaabbaaabbab","baaaabababaaababbaabbbabaaabbbbabbbbaaaabbabbbbbbbbababbaaaaabaabaaabbaabbbbbabababaabbbbaabbbbbabbaabaaabaababbbabbbabaababbaaaabbaaaaaabaababbbabaabbbaaabbbabbbaabbbbbbaabbabbbbabaabbbbaba","bbbaababaabaabbabbaabbabbaabbbbabaabbabbbbbbbabbaaaaababaaabbbaba","baaaaababaabaabaabbbbabbbbbaabbaabbaaababaabaababaabbaaabbabbbabbbaababababbaaaab","baabaaababbabbbaaaabbaabbaababbaababbbaabaabaaaaaabbbbababaaabaaabaababbaabbabbaababbbbbabbabbaabbaabbbabbbaabb","bbaaaaabbbaaabbbaaaaaaaaaabaaaaa","bbbbbbabaaaaabbbbaaabbabaababaabababbabbabaabababababbaabbabbbabbbababa","bbaabbbaabbabababaaaaaabbaabbababbbbabaabbbaabbabaabbbabbbabbaaabbabbababaaabbbababbabbbbbbbbaaaaabbaa","abaabbbaabbbbaabbabaabaaabaabaaaabbabbbabbaaabbbbababaabaaabaaaaaaaabaaaababbababaabbbbbaababaabbbbabbaaabbbabbabbbbabbbbaabaaa","bababbabbaaabbabaababbbbaabaabbbbbbababaabbbbaababababbaabbaabaaaababbabbabab","baaabbabbaaababbbbbbbaabaaabbabbaaabbabababbaaaabaabbbbaaaabbabbbbbbabaaaaabaabaaaaabababbbaabbaabbabbbbbabaababababbbbbbaabbbabbbaaabaabababaabaabbbbbbbbabaaaaabbaababab","ababababababbbabbabbbbbabbabbbbabbaaabbbbbbbbbbabbaabaabbbababbabbbaaaababbaabbbaab","baaaabbababbabaabbabbaabbbbabbbabbabbbbbabaaaabaabbbabbaababbabababaaaaabaaaababbbabbbaaaaabbbabbbaaaabbbbbaaaba","baababbbaaaabbbaaababbabaababbbbbaaabaabaaabababbbbaabbaaabaaabaaaaaabbbbbaabaaaababbbaabb","aaabaabbabaaaaaaaaaabbb","abbbaabaabbbbbabbaababbaaaaababbaaaaabbabbbb","ababaabababbbabbbbaaabbabbbaaaaaaabbabbbaba","baababbaabbbaabbbbbbaaabbbbaaaabbbbabaabbaaabaaababbbaaabbaabaabaabaaabbbbbaabaaaaab","babbabababaabbbaabababaaaaaaaaaabbbbabbababbbaaaabbaabababbbbbbbababaaaababbaaaabaabaaabaabaaaaababbbbababbaabbaaabbabaaababbbbbabbbaaabaababbaabbabbbbaaaabababaaa","abbbbbaaaaabbaabbbabaabbabaabbbaaabbaaabaabbb","abbababb","aababaaabbbabbbbaaaabaababbababbbaaaaabbababbbbaaaaaababababaabaaaabbbabbaababbbabbabaabbababbbbabbabbbabaaabababaababbbbbaaabaabaaaabbabbaaababbabaaaaa","abbbaaaaabaabbbabbbabbaaabbaababababbbaabbababaababaabbaaababbabbb","aaabaaabaabaababbabbbbaaaaaaaaabbbabbaabbababbaabababbbbbabbabababbabaaaabbbbabbbbbbbabbabaabababbaaabbaaaaaabbababbbbbbbaabbabbaaaababbabaaabbaabaaababaabaaaabaaba","baabbabbaabbbabbbbabbbaabbabaababaaaabaaaabbaaabaaababbabbbbbabaabbbaababaaababaababbaabaabaabababaaabbbbaabbbabbbbbba","abaababaaabaabbaabaaababbaabbbababbbaaaaaabbbabaaababbaabbbbaaabaabbaaabaaaababbabbbbbababbbaabbaaababaaaaaaababbbbbba","aaaabbaaaaaabbbaaaaabbaabbaabaabbababbbbbabababbababbabbaaaaabbaaabbabbaaabbbbbbaaabbbbbabbbbbabbabbaaaaaabbbbbaaaaaabbabbbbbbabbbaabbbaababbbbbabbaaabaa","ababbaaaababababbabaaabaaaaaabbbbababaababbababaabaabababaaaabbaaabaaaaaaabbbbababbabbbbabbbbbbabbbabaabbbabbbbbabbbbbababbbbaabbbaabbbababaaaabbbbaaabbab","bbabaababbabbbbbbaabbaaaabbaaabbabbaaabbabbaabaaabbbabbbababaabbbaaba", "abbb", "bbba","bbaaabbbaabaababbbababaaabbbbababbbbbaabaaabbbaabbbaaaaabbaabbaabaaabbabaababaaabbaababaabbbbbbaaabbabaabababaabbbaaaaabbbaaaabaabbababaaababaabbaabaaaaabaaaababbabaabababababaabaaaabaaabbaaabbbbababa","abbaaabbbaabbabb","abbbabbaaaabaabaaababaaaaabababbbaabbbbaabbbaaa","babaaabbbbbb","baaabaaabbbabaabbbaabaabbaaaabbbabbabbbbbaabbabbbabaabababaabbbbabaabaabbaaabbbabaaaaaaaaaabbbbaaabbaaaaaabaababbaabbabaabbbabaaabbbbaabbaababba","babababbbbabbaaaaaabbbbbaba","babba","abbbabaabbabbbbbbbbababaaaaaab","bbabbabbbabaaabbbaaababbbbaaaaaaabab","bbabbaabbbabaaaaaababaabbbabaaabaaababaabaaaaaaaaaaabbaababaababbababbabbababbbaaabbaaaabbaabbbbaaabbabbbabaabbbbbabababbaabaabbbabaabaaabaaababbbabbabbaababaabbbbaabaabbabbbbabbabbaababbbbba","bbaaabaaababaaaabbaabbabbbaabbaaabaababbaaababbbaaabaabaabbabababaaaabbbbbaaaabbbbbbababbbbabbbababbaababaababbbabaaabbabaaaabababaaabababaaabbbbbaaaaababaabbbbaabaaabba","ababaaaaaabbabbabba","aaabababaabaaabaaaaabaaabaababbbbbababbbabbbbbbaabbaaaaaba","baabbbab","abbaaaaababbbaaaabbbaaabbaaababbababababaabbabaabaaabaabaaabbaaabbababbaabaaaabaabababbbbbbabaabaaabaaaababbaababbaabbbbbaabbbbbbabaa","ababaaabbababbabbbaabbbaabaaaaaaaabbabaabaaaaaabaa"
    };
   System.out.println(palindromePairs(setFail));
  } 
}
