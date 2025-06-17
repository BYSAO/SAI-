//手机号检验
function checkTelephone(telephone) {
    var reg = /^[1][3,4,5,7,8][0-9]{9}$/;
    if (!reg.test(telephone)) {
        layer.msg("手机号格式不正确!");
        return false;
    } else {
        return true;
    }
}

//校验邮箱
function checkEmail(strEmail) {

    if (strEmail.length == 0) {
        layer.msg("账号不能为空!");
        return false;
    }
    if (strEmail.indexOf("@", 0) == -1) {
        layer.msg("账号邮件格式不正确\n必须包含@符号！");
        return false;
    }
    if (strEmail.indexOf(".", 0) == -1) {
        layer.msg("账号邮件格式不正确\n必须包含.符号！");
        return false;
    }
    return true;
}

/**
 * 公共页面跳转
 * @param url
 */
function commonGoView(url) {
    window.location.href = url
}

/**
 * 公共刷新当前页面
 */
function commonReload() {
    location.reload()
}

/**
 * 可以实现 删除，取消等相关操作
 */

function commonDel() {
    $(document).on('click', '.obj_del', function () {
        let thisPageModular = $("#thisPageModular").val();
        let id = $(this).attr("data-id");
        let value = $(this).attr("data-value");
        let successUrl = $(this).attr("data-successUrl");
        let liEle = $(this).parents('li');
        doDel(thisPageModular, [id], value, successUrl);
    })
}

function commonClickGoView() {
    $(document).on('click', '.obj_go', function () {
        let goURL = $(this).attr("data-go-url");
        commonGoView(goURL);
    })
}

//执行删除操作
function doDel(thisPageModular, idArr, value, successUrl) {
    selectBox(value + '操作提示', '确定' + value + '当前选中内容吗？', function () {
        layer.closeAll();
        for (idDel in idArr) {
            $.ajax({
                url: '/' + thisPageModular + '/del',
                data: {
                    id: idArr[idDel],
                },
                success: function (data) {
                    if (idArr.length == 1) {
                        if (data) {
                            layer.msg(value + "成功！");
                        } else {
                            layer.msg(value + "失败！");
                        }
                        setTimeout(function () {
                            layer.closeAll();
                            if (successUrl) {
                                commonGoView(successUrl);
                            } else {
                                commonReload();
                            }

                        }, 2000);
                    }
                }
            })
        }
        if (idArr.length > 1) {
            layer.msg(value + "成功！");
            setTimeout(function () {
                layer.closeAll();
                if (successUrl) {
                    commonGoView(successUrl);
                } else {
                    commonReload();
                }

            }, 2000);
        }

    });
}

function commonAdd() {
    $(document).on('click', '.obj_add', function () {
        let thisPageModular = $("#thisPageModular").val();
        let id = $(this).attr("data-id");
        let dataUrl = $(this).attr("data-add-url");
        let value = $(this).attr("data-value");
        let title = $(this).attr("data-title");
        let successUrl = $(this).attr("data-successUrl");
        let liEle = $(this).parents('li');
        selectBox(value + '操作提示', '确定' + value + '当前内容吗？', function () {
            layer.closeAll();
            $.ajax({
                url: '/' + dataUrl + '/add',
                data: {
                    VolunteerServe: id,
                    Project: id,
                    title: title,
                    My: true
                },
                success: function (data) {
                    if (data != 'false-has-double') {
                        layer.msg("操作成功！");
                        setTimeout(function () {
                            layer.closeAll();
                            if (successUrl) {
                                commonGoView(successUrl);
                            } else {
                                commonReload();
                            }
                        }, 2000)
                    } else {
                        layer.msg("请不要重复申请！");
                    }

                }
            })
        });
    })
}

/**
 * 可以实现 状态数据的更新操作
 */
function commonUpStatus() {
    $(document).on('click', '.obj_up_status', function () {
        let thisPageModular = $("#thisPageModular").val();
        let id = $(this).attr("data-id");
        let value = $(this).attr("data-value");
        let successUrl = $(this).attr("data-successUrl");
        let liEle = $(this).parents('li');
        selectBox(value + '操作提示', '确定修改当前数据状态为' + value + '吗？', function () {
            layer.closeAll();
            $.ajax({
                url: '/' + thisPageModular + '/update',
                data: {
                    id: id,
                    status: value
                },
                success: function (data) {
                    if (data) {
                        layer.msg("操作成功！");
                        setTimeout(function () {
                            layer.closeAll();
                            if (successUrl) {
                                commonGoView(successUrl);
                            } else {
                                commonReload();
                            }
                        }, 2000)
                    } else {
                        layer.msg("操作失败！");
                    }

                }
            })
        });
    })
}

/**
 * 公共分页内容
 */
function commonPage(clickUrl) {
    layui.use(['element', 'laypage', 'laydate', 'form'], function () {
        let thisPageModular = $("#thisPageModular").val();
        let laypage = layui.laypage;
        //分页
        laypage.render({
            elem: 'page' //注意，这里的 test1 是 ID，不用加 # 号
            , count: $("#countMessage").val() ? $("#countMessage").val() : "0"//数据总数，从服务端得到
            , limit: $("#rowsMessage").val() ? $("#rowsMessage").val() : "10"
            , limits: [10, 20, 30, 40, 50]
            , curr: $("#pageMessage").val() ? $("#pageMessage").val() : "1"
            , theme: '#FFB800'
            , jump: function (obj, first) {
                //obj包含了当前分页的所有参数，比如：
                //得到当前页，以便向服务端请求对应页的数据。
                console.log(obj.curr);
                //首次不执行
                if (!first) {
                    //do something
                    let URL = clickUrl;
                    URL += "&page=" + obj.curr
                    window.location.href = URL
                }
            }
        });
    });
}


/**
 * 选择弹框
 * @param title 弹框展示的标题内容
 * @param content 弹框展示的主题内容
 * @param yesCallBack 弹框确定按钮事件
 */
function selectBox(title, content, yesCallBack) {
    layer.open({
        type: 1 //此处以iframe举例
        , title: title
        , area: ['390px', '260px']
        , shade: 0
        , maxmin: true
        , offset: 'auto'
        , content: '<div style="padding: 15px;">' + content + '</div>'
        , btn: ['确定', '关闭'] //只是为了演示
        , yes: function () {
            yesCallBack();
        }
        , btn2: function () {
            layer.closeAll();
        }
        , zIndex: layer.zIndex //重点1
        , success: function (layero, index) {
            layer.setTop(layero); //重点2. 保持选中窗口置顶

            //记录索引，以便按 esc 键关闭。事件见代码最末尾处。
            layer.escIndex = layer.escIndex || [];
            layer.escIndex.unshift(index);
            //选中当前层时，将当前层索引放置在首位
            layero.on('mousedown', function () {
                var _index = layer.escIndex.indexOf(index);
                if (_index !== -1) {
                    layer.escIndex.splice(_index, 1); //删除原有索引
                }
                layer.escIndex.unshift(index); //将索引插入到数组首位
            });
        }
        , end: function () {
            //更新索引
            if (typeof layer.escIndex === 'object') {
                layer.escIndex.splice(0, 1);
            }
        }
    });
}

//初始化表格内容
function installLayUiTable(param) {
    /**
     * attachParam:初始化url 附加参数
     * searchTopParam：顶部查询的参数
     * searchUrl：可查询非默认 /getAll2Table路由
     */
    let cols = param.cols;
    let thisPageModular = param.module;
    let thisHtmlModular = $("#thisHtmlModular").val();
    let baseUrl = "/" + thisPageModular;


    //跳转新增页面
    let addOrUpUrl = baseUrl + "/addOrUpView?pageModular=" + thisHtmlModular;
    let detailsUrl = baseUrl + "/detailsView?pageModular=" + thisHtmlModular;
    //删除
    let delUrl = baseUrl + "/del?";
    //顶部检索
    let searchTopParam = param.searchTopParam ? param.searchTopParam : "&title=";


    //表格查询限制条件
    let attachParam = param.attachParam ? param.attachParam : "";
    //查询表格数据
    let getAll2TableUrl = param.searchUrl ? (baseUrl + param.searchUrl) : (baseUrl + "/getAll2Table?")
    if (attachParam) {
        getAll2TableUrl += attachParam;
    }


    layui.use(['table', 'util', 'dropdown'], function () {
        var table = layui.table;
        var util = layui.util;
        var dropdown = layui.dropdown;
        installTable(getAll2TableUrl);

        function installTable(url) {
            //初始化表格
            table.render({
                elem: '#table-data-list', //table 容器的选择器或 DOM
                url: url,
                method: "post",//请求方式
                toolbar: '#table-data-list-toolbar-top',  //table上方的工具条id
                defaultToolbar: ['filter', 'print', 'exports', { //自定义头部工具栏右侧图标。如无需自定义，去除该参数即可
                    title: '提示'
                    , layEvent: 'LAYTABLE_TIPS'
                    , icon: 'layui-icon-tips'
                }],//table工具条默认三个值['filter','print','exports'],过滤，打印，导出
                page: true,//开启分页器
                request: {
                    pageName: 'page' //页码的参数名称，默认：page
                    , limitName: 'rows' //每页数据量的参数名，默认：limit
                },
                loading: true,
                parseData: function (res) { //res 即为原始返回的数据
                    if (res.total < 1) {
                        return {
                            'msg': '暂无相关数据', //提示文本
                            "count": 0, //解析表格数据总条数 eg:共100页
                            "data": []//解析table表格数据源
                        };
                    } else {
                        return {
                            "code": 0, //解析接口状态
                            "count": res.total, //解析表格数据总条数 eg:共100页
                            "data": res.rows//解析table表格数据源
                        };
                    }
                },
                where: {},//where用来传递请求时额外的参数 eg:productName
                cellMinWidth: 80, //全局定义常规单元格的最小宽度，layui 2.2.1 新增
                limit: 10,//默认每页条数
                limits: [10, 15, 20, 25, 30],//每页可展示条数选项
                text: '对不起，加载出现异常！',
                done: function (res, curr, count) {//此res为上述parseData对应的函数解析完初始返回值构成的对象
                    //如果是异步请求数据方式，res即为你接口返回的信息。
                    //如果是直接赋值的方式，res即为：{data: [], count: 99} data为当前页数据、count为数据总长度
                    console.log(res);
                    //得到当前页码
                    console.log(curr);
                    //得到数据总量
                    console.log(count);
                    hoverOpenImg();//显示大图
                    $('table tr').on('click', function () {
                        $('table tr').css('background', '');
                        $(this).css('background', '<%=PropKit.use("config.properties").get("table_color")%>');
                    });
                },
                cols: cols,
            });
        }

        //头工具栏事件
        table.on('toolbar(table-data-list)', function (obj) {
            console.log(obj)
            var id = obj.config.id;
            var checkStatus = table.checkStatus(id);
            switch (obj.event) {
                //数据新增
                case "addData":
                    window.location.href = addOrUpUrl;
                    break;
                //批量删除
                case "delAll":
                    var data = checkStatus.data;
                    var idDel = [];
                    for (x in data) {
                        $.post(delUrl, {id: data[x].id}, function (res) {
                            idDel.push(data[x].id)
                        });
                    }
                    doDel(thisPageModular, '删除', idDel);

                    break;
                //执行搜索
                case 'submitSearch':
                    let submitSearchValue = $("#submitSearchValue").val();
                    installTable(getAll2TableUrl + searchTopParam + submitSearchValue)
                    break;
                //自定义头工具栏右侧图标 - 提示
                case 'LAYTABLE_TIPS':
                    layer.alert('如有问题，请联系系统管理员 xxx@System.com');
                    break;
            }
        });
        //右侧工具栏
        table.on('tool(table-data-list)', function (obj) {

            if (obj.event === 'sp') {
                window.location.href = addOrUpUrl + "&id=" + obj.data.id;
            }

            if (obj.event === 'gs') {
                window.location.href = "/OpenShow/addOrUpView?pageModular=villagecommittee" + "&evaluate=" + obj.data.id;
            }


            //修改事件
            if (obj.event === 'edit') {
                window.location.href = addOrUpUrl + "&id=" + obj.data.id;
            }
            if (obj.event === 'del') {
                doDel(thisPageModular, [obj.data.id], '删除',);
            }
            if (obj.event === 'del_XC') {
                doDel(thisPageModular, [obj.data.id], '下撤',);
            }
            //更多
            if (obj.event === 'more') {
                let moreArr = [{
                    title: '查看',
                    id: 'detail'
                }, {
                    title: '删除',
                    id: 'del'
                }]

                // 更多 - 下拉菜单
                dropdown.render({
                    elem: this, // 触发事件的 DOM 对象
                    show: true, // 外部事件触发即显示
                    data: moreArr,
                    click: function (menudata) {
                        if (menudata.id === 'detail') {
                            window.location.href = detailsUrl + "&id=" + obj.data.id;
                        }
                        if (menudata.id === 'del') {
                            doDel(thisPageModular, [obj.data.id], '删除',);
                        }
                    },
                    align: 'right', // 右对齐弹出
                    style: 'box-shadow: 1px 1px 10px rgb(0 0 0 / 12%);' // 设置额外样式
                })
            }

        });
    });
}


function hoverOpenImg() {
    var img_show = null; // tips提示
    $('td img').hover(function () {
        //alert($(this).attr('src'));
        var img = "<img class='img_msg' src='" + $(this).attr('src') + "' style='width:180px;height: 180px' />";
        img_show = layer.tips(img, this, {
            tips: [2, 'rgba(41,41,41,.5)']
            , area: ['210px']
        });
    }, function () {
        layer.close(img_show);
    });
    $('td img').attr('style', 'max-width:25px');
}
