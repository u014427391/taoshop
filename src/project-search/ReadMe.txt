全局搜索引擎


### 数据库索引和Lucene检索对比

|比较项   |Lucene检索| 数据库检索|
|:--------|:--------|:--------|
|数据检索 |	从Lucene的索引文件中检出 |	由数据库索引检索记录|
|索引结构 |	Document（文档）|	Record（记录）|
|全文检索 |	支持 |	不支持|
|模糊查询 |	支持 |	不支持|
|结果排序 |	支持排序 |	不能排序|

Lucene搜索的API类主要有4个 IndexSearch，Query，QueryParser，Hits

### Lucene搜索过程
Lucene的索引结构是文档(Document)形式的，下面简单介绍一下Lucene搜索的过程
1. 将文档传给分词组件(Tokenizer)，分词组件根据标点符号和停词将文档分成词元(Token)，并将标点符号和停词去掉。

停词是指没有特别意思的词。英语的是指比如a、the等等单词

文章1内容：Tom favorite fruit is apple.

经过分词处理后，变成[Tom][facorite][fruit][apple]


2. 再将词元传给语言处理组件(Linguistic Processor)

英语的单词经过语言处理组件处理后，字母变为小写，词元会变成最基本的词根形式，比如likes变成like

经过分词处理后，变成[tom][favorite][fruit][apple]

3. 然后得到的词元传给索引组件(Indexer)，索引组件处理得到索引结构，得到关键字、出现频率、出现位置分别作为词典文件（Term Dictionary）、频率文件（frequencies）和位置文件（positions）保存起来，然后通过二元搜索算法快速查找关键字

|关键字   |文章号[出现频率]| 出现位置|
|:--------|:--------|:--------|
|tom | 1[1] | 1 |
|favorite| 1[2] | 2 |
|fruit| 1[3] | 3 |
[apple| 1[4] | 4 |

