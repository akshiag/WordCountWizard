import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class WordCountTest extends AnyFlatSpec with Matchers {
  "WordCount" should "count words correctly" in {
    /**
     * A test suite for the WordCount class, which asserts that word counting is done correctly.
     */
    val wordCount = new WordCount()

    val testFilePath = "src/test/input/test_input.txt"

    val wordCountResult = wordCount.countWords(testFilePath)

    // Define the expected word count result
    val expectedWordCount = Array(
      ("this", 2),
      ("is", 2),
      ("a", 2),
      ("test", 2),
      ("input", 1),
      ("text", 1),
      ("only", 1)
    )

    wordCountResult.sorted should contain theSameElementsAs expectedWordCount.sorted
  }
}
