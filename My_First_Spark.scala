package sqlsamples

import org.apache.spark.sql.SQLContext
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.mllib.stat.Statistics

object StatsDescribeinSpark {
   def main(args:Array[String]): Unit = {
    val conf = new SparkConf()
      .setMaster("local[2]")
      .setAppName("SparkVariableIdentification")
    val sc = new SparkContext(conf)
    val sqlContext = new SQLContext(sc)
    import sqlContext.implicits._
    val students_data = sqlContext.read.format ("com.databricks.spark.csv")
      .option("header","true")
      .option("inferSchema", "true")
      .load("/home/cloudera/workspace/Spark2Demo/data/students.csv")
    students_data.show(5)
    
    val summary = students_data.describe()
    summary.show()
    
  }
}