﻿準備

JDK7
で実施

1.pluginsを落とす。
	SpringSource Update Site for Eclipse 4.2 - http://dist.springsource.com/release/TOOLS/update/e4.2
	・Gradle IDEのみで良い。

2.プロキシ設定（eclipse)
	ネットワーク接続
	httpとhttpsにjitproxy:3128を設定

3.プロキシ設定（Gradle)
	gradleSettingのgradle.propertiesをC:/Users/ユーザー/.gradleに配置

4.クラスパス変数追加
	GRADLE_USER_HOME
	C:/Users/ユーザー/.gradle

5.プロジェクト右クリックしてGradle全てリフレッシュ


http://172.31.122.41:8080/project-support/chat/index


IntelliJに対応

1.gradleをダウンロード（後々必要になります）

2.クローンをつくる(Ideaからでもよい）
  git clone ssh://centos/var/lib/git/project-support.git

3.プロジェクトのインポート
  Gradleプロジェクトとしてインポート
  Gradleホームに1のディレクトリを設定





 CREATE TABLE TEST11(ID INT PRIMARY KEY,TEST_CHAR VARCHAR(40))

 DROP TABLE TEST11
