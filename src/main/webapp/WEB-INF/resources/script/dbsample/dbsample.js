/** @jsx React.DOM */
var socketPushService = new SocketPushService();

//テーブルのモデル
var TableSingle = React.createClass({
    propTypes: {
      id:   React.PropTypes.number.isRequired,
      schema: React.PropTypes.string.isRequired,
      name: React.PropTypes.string.isRequired
    },
    render() {
      return (<div>[{this.props.id}]:{this.props.schema}:{this.props.name}</div>);
    }
});

//リスト部のコンポーネント
var TableList = React.createClass({

    //初期化（リスナーの設定）
    initializeTables: function () {
        var socket = this.props.socketPushService;
        //受信時のリスナー
        socket.bindReceiveListener(function (message) {
            if (message.messageType === 'dataCompleted') {
                //現在は全置換え(this.state.tablesに差分だけ操作したほうが早いと思う）
                this.state.tables = message.tables;
                this.setState({tables: this.state.tables});
            }
            if (message.messageType === 'error') {
            }
        }.bind(this));
    },
    //データ読み込み要求
    loadTables: function () {
        var socket = this.props.socketPushService;
        //リクエスト要求
        socket.sendRequest({messageType: 'loadTables'});
    },
    //データ送信要求
    createTables: function () {
        var socket = this.props.socketPushService;
        var ddl = React.findDOMNode(this.refs.sqlText).value.trim();
        //リクエスト要求
        socket.sendRequest({messageType: 'createTables', sqlText: ddl});
    },
    //DOMツリー生成後初期化
    componentDidMount: function() {
        this.initializeTables();
        this.loadTables();
    },
    //初期の状態
    getInitialState() {
        return {
          tables: [ {"id": "0", "schema": "sample", "name": "sample"},{"id": "1", "schema": "sample2", "name": "sample2"},{"id": "2", "schema": "sample3", "name": "sample3"} ]
        }
    },
    render() {
      var tables = this.state.tables.map((table) => {
        return <TableSingle id={table.id} schema={table.schema} name={table.name}/>
      });
      return (
          <div class="page-list">
              <textarea name="sqlText" rows="10" cols="50" ref="sqlText"></textarea>
              <input type="button" value="create" onClick={this.createTables} />
              <h2>TableList</h2>
              {tables}
          </div>
      );
    }
});

//ヘッダ部のコンポーネント
var TableHead = React.createClass({
    render() {
      return (
          <div class="page-header">
              <h1>Sample</h1>
          </div>
      );
    }
});

//全体のコンポーネント
var ALL = React.createClass({
    render() {
      return (
          <div class="page-all">
            <TableHead />
            <TableList socketPushService={this.props.socketPushService} />
          </div>
      );
    }
});

//全体の描画
React.render(
  <ALL socketPushService={socketPushService} />,
  document.getElementById('content')
);
