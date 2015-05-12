概要

技術調査のための検証

環境

Runtime:java8
Build:gradle
ApServer:jetty
DB:H2
Other:Spring4(WebSocket)、Mybatis、thymeleaf、react.js

準備

IntelliJに対応

1.gradleをダウンロード（後々必要になります）

2.クローンをつくる(Ideaからでもよい）
  git clone https://github.com/ds1234567890/sample

3.プロジェクトのインポート
  Gradleプロジェクトとしてインポート

実行方法

SimpleWebStarterを実行するとJettyが立ち上がります。

各URL
chart Apl
http://IP:8080/sample/chat/index
react Apl
http://IP:8080/sample/dbSample/index

※ddlテスト用
 CREATE TABLE TEST11(ID INT PRIMARY KEY,TEST_CHAR VARCHAR(40))
 DROP TABLE TEST11



連携

slack、trello
