spark-submit \
--master yarn \
--deploy-mode cluster \
--class WordCount \
--name "Spark WC in Cluster Mode" \
--conf spark.default.parallelism=10 \
Desktop/sparkWC.jar \
/sample1 \
/sparkWCOut \
