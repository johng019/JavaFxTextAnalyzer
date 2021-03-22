package sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.Assert.*;
import java.util.*;

public class TopWordsUITest {


   TopWordsUI topWords = new TopWordsUI();

    Scanner file;
    FileInputStream reader;

   @Before
   public void init(){

       try{
           reader = new FileInputStream("c:/Users/rick3/source/JavaFxTextAnalyzer/src/TextAnalyzer.txt");

           }
       catch(FileNotFoundException e){
           e.printStackTrace();
       }
        file = new Scanner(reader);

   }


    @Test  //TextAnalyzer.txt
    public void testReadFromTargetRelativePath() throws IOException{

        File file = new File("src/TextAnalyzer.txt");
        assertTrue(file.exists());
    }

    @Test
    public void testReadFromAnInvalidPath() {
 File file = new File("src/somefile.txt");
        assertFalse(file.exists());
    }




    @Test
    public void testStringArrayContainsWord(){
        topWords.words.contains("the");
        assertTrue("the",true);
    }

    @Test
    public void createWordArray() throws IOException {
        var actual = topWords.createWordArray(file);
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("once", "upon", "a", "midnight", "dreary", "while", "i", "pondered", "weak", "and", "weary", "over", "many", "quaint", "curious", "volume", "of", "forgotten", "lore", "nodded", "nearly", "napping", "suddenly", "there", "came", "tapping", "as", "some", "one", "gently", "rapping", "at", "my", "chamber", "door", "tis", "visitor", "muttered", "only", "this", "nothing", "more", "ah", "distinctly", "remember", "it", "was", "in", "the", "bleak", "december", "each", "separate", "dying", "ember", "wrought", "its", "ghost", "floor", "eagerly", "wished", "morrowvainly", "had", "sought", "to", "borrow", "from", "books", "surcease", "sorrowsorrow", "for", "lost", "lenore", "rare", "radiant", "maiden", "whom", "angels", "name", "nameless", "here", "evermore", "silken", "sad", "uncertain", "rustling", "purple", "curtain", "thrilled", "mefilled", "me", "with", "fantastic", "terrors", "never", "felt", "before", "so", "that", "now", "still", "beating", "heart", "stood", "repeating", "visiter", "entreating", "entrance", "late", "is", "presently", "soul", "grew", "stronger", "hesitating", "then", "no", "longer", "sir", "said", "or", "madam", "truly", "your", "forgiveness", "implore", "but", "fact", "you", "faintly", "scarce", "sure", "heard", "youhere", "opened", "wide", "darkness", "deep", "into", "peering", "long", "wondering", "fearing", "doubting", "dreaming", "dreams", "mortals", "ever", "dared", "dream", "silence", "unbroken", "stillness", "gave", "token", "word", "spoken", "whispered", "an", "echo", "murmured", "back", "merely", "turning", "all", "within", "burning", "soon", "again", "something", "louder", "than", "surely", "window", "lattice", "let", "see", "what", "thereat", "mystery", "explore", "be", "moment", "wind", "open", "flung", "shutter", "when", "flirt", "flutter", "stepped", "stately", "raven", "saintly", "days", "yore", "not", "least", "obeisance", "made", "he", "minute", "stopped", "stayed", "mien", "lord", "lady", "perched", "above", "bust", "pallas", "just", "sat", "ebony", "bird", "beguiling", "fancy", "smiling", "by", "grave", "stern", "decorum", "countenance", "wore", "though", "thy", "crest", "shorn", "shaven", "thou", "art", "craven", "ghastly", "grim", "ancient", "wandering", "nightly", "shore", "tell", "lordly", "on", "nights", "plutonian", "quoth", "nevermore", "much", "marvelled", "ungainly", "fowl", "hear", "discourse", "plainly", "answer", "little", "meaninglittle", "relevancy", "bore", "we", "cannot", "help", "agreeing", "living", "human", "being", "yet", "blessed", "seeing", "his", "beast", "sculptured", "such", "sitting", "lonely", "placid", "spoke", "if", "did", "outpour", "farther", "uttered", "feather", "fluttered", "till", "scarcely", "other", "friends", "have", "flown", "morrowhewill", "leave", "hopes", "startled", "broken", "reply", "aptly", "doubtless", "utters", "stock", "store", "caught", "unhappy", "master", "unmerciful", "disaster", "followed", "fast", "faster", "songs", "burden", "dirges", "hope", "melancholy", "nevernevermore", "straight", "wheeled", "cushioned", "seat", "front", "velvet", "sinking", "betook", "myself", "linking", "unto", "thinking", "ominous", "gaunt", "meant", "croaking", "engaged", "guessing", "syllable", "expressing", "whose", "fiery", "eyes", "burned", "bosoms", "core", "divining", "head", "ease", "reclining", "cushions", "lining", "lamplight", "gloated", "oer", "violet", "gloating", "sheshall", "press", "methought", "air", "denser", "perfumed", "unseen", "censer", "swung", "seraphim", "footfalls", "tinkled", "tufted", "wretch", "cried", "god", "hath", "lent", "theeby", "these", "sent", "thee", "respiterespite", "nepenthe", "memories", "quaff", "oh", "kind", "forget", "prophet", "thing", "evilprophet", "devil", "whether", "tempter", "tempest", "tossed", "ashore", "desolate", "undaunted", "desert", "land", "enchanted", "home", "horror", "hauntedtell", "thereisthere", "balm", "gileadtell", "metell", "heaven", "bends", "usby", "both", "adore", "sorrow", "laden", "distant", "aidenn", "shall", "clasp", "sainted", "our", "sign", "parting", "fiend", "shrieked", "upstarting", "get", "black", "plume", "lie", "has", "loneliness", "unbrokenquit", "take", "beak", "out", "form", "off", "flitting", "pallid", "seeming", "demons", "him", "streaming", "throws", "shadows", "shadow", "lies", "floating", "liftednevermore"));
       assertEquals (expected,actual);
    }

    @Test
    public void createFrequencyArray() throws IOException {

        var actual = topWords.createFrequencyArray(file);
        int expected = 442;

       assertEquals (expected,actual);
    }



}

/** Ctrl + Shift + F10 run current method if in method.
 * current class if not inside a method.
 * Shift + F10: ReRun last Test.
 **/