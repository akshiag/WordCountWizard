
import org.apache.spark.sql.SparkSession
import org.apache.spark.rdd.RDD

object Main {
  def main(args: Array[String]): Unit = {
    val inputFilePath = "src/main/input/test.txt"

    // Create an instance of the WordCount class
    val wordCount = new WordCount()

    // Call the countWords method to get the word count result
    val wordCountResult = wordCount.countWords(inputFilePath)

    // Print the word count result
    wordCountResult.foreach { case (word, count) =>
      println(s"$word -> $count")
    }

  }
}
