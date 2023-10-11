import org.apache.spark.sql.SparkSession
import org.apache.spark.rdd.RDD

class WordCount {
  def countWords(filePath: String): Array[(String, Int)] = {
    /**
     * Count the occurrences of words in a text file and return the results as an array of word-count pairs.
     *
     * @param filePath The path to the text file to be processed.
     * @return An array of tuples where each tuple contains a word and its count.
     */

    val spark = SparkSession.builder().master("local[1]")
      .appName("WordCountApp")
      .getOrCreate()

    // Load the input text file into an RDD using the provided filePath
    val lines: RDD[String] = spark.sparkContext.textFile(filePath)

    // Tokenize and count words
    val wordCounts: RDD[(String, Int)] = lines
      .flatMap(line => line.split("\\s+")) // Split by whitespace
      .map(word => word.replaceAll("[^a-zA-Z0-9]", "").toLowerCase) // Remove special characters and convert to lowercase
      .filter(word => word.nonEmpty) // Filter out empty words
      .map(word => (word, 1))
      .reduceByKey(_ + _)

    // Collect the result and return it
    wordCounts.collect()
  }
}
