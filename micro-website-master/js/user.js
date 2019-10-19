$(document).ready(function() {
    //保存事件
    $('#to-save').click(function(event) {
        console.log("user.js->#to-save.click");
        //获取值
        var uname = $(".modal #uname").val();
        var passwd = $(".modal #passwd").val();
        var confirmpwd = $(".modal #confirmpwd").val();
        var realname = $(".modal #nkname").val();
        var email = $(".modal #email").val();
        if (uname && passwd && confirmpwd && realname && email) {
            if (confirmpwd === passwd) {
                var obj = {
                    userName: uname,
                    userPassword: passwd,
                    realName: realname,
                    userEmail: email
                };
                console.log('传递给后台的数据是：', obj);
                // 提交数据给后台
                saveOrUpdateUser(obj);
            } else {
                alert('密码不一致');
            }
        } else {
            alert('请输入完整的信息');
        }
    });
    //新增用户事件
    $('#add').click(function(event) {
        console.log("user.js->新增.click");
        // 清空表单数据，显示模态框
        $('.modal input[type=text]').val('');
        $('.modal input[type=password]').val('');
        $('.modal input[type=email]').val('');
        //设置模态框标题
        $('.modal-title').text('新增用户');
        $('#myModal').modal('show');
    });
    //开关状态改变触发事件，无法直接通过$('.mySwitch input')绑定该事件，会无法触发事件
    $('.allUser').on({'switchChange.bootstrapSwitch':function(event, state) {
            var id = $(this).closest('.switch').prev('input').val();
            var obj = {
                id: id,
                status: state
            };
            changeStatus(obj);
        }
    },'[type="checkbox"]');
    //
    $('#showAll').click(function(event) {
        console.log("user.js->#showAll.click");
        findAllUser();
    });
    // findAllUser();
    //查询所有用户
    function findAllUser() {
        console.log("user.js->findAllUser");
        getAjax('/user/queryUserInfoForPage', 'post', null,
            function(res) {
                res.data.forEach(function(item) {
                    var str = `<div class="col-sm-4">
            <div class="thumbnail">
                <img src="./images/goat.jpg" alt="">
                <div class="caption">
                    <div class="row">
                        <div class="col-sm-4 col-sm-offset-1">用户名</div>
                        <div class="col-sm-7">` + (item.userName ? item.userName : '-') + `</div>
                    </div>
                    <div class="row">
                        <div class="col-sm-4 col-sm-offset-1">真实姓名</div>
                        <div class="col-sm-7">` + (item.realName ? item.realName : '-') + `</div>
                    </div>
                    <div class="row">
                        <div class="col-sm-4 col-sm-offset-1">注册时间</div>
                        <div class="col-sm-7">` + (item.createTime ? item.createTime : '-') + `</div>
                    </div>
                    <div class="row">
                        <div class="col-sm-4 col-sm-offset-1">email</div>
                        <div class="col-sm-7">` + (item.userEmail ? item.userEmail : '-') + `</div>
                    </div>
                    <div class="row">
                        <div class="col-sm-4 col-sm-offset-1">状态</div>
                        <div class="col-sm-7">
                            <input type="hidden" value="` + item.userId + `">
                            <div class="switch mySwitch">
                                <input type="checkbox"/>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>   `;
                    $('.allUser').append(str);
                    //给开关设置属性值,.mySwitch input会选中多个，所以每次应该给最后一个追加属性值
                    $('.mySwitch input:last').bootstrapSwitch('state', item.enabled);
                });
            },
            function(error) {
                console.log(error);
            });
    }

    //保存或刷新
    function saveOrUpdateUser(obj) {
        getAjax('user/saveUserInfo', 'post', obj,
            function(res) {
                alert('用户创建成功！');
                findAllUser();
                $('#myModal').modal('hide');
            },
            function(error) {
                console.log(error);
            });
    }
    //修改状态
    function changeStatus(obj) {
        getAjax('/manager/user/changeStatus', 'post', obj,
            function(res) {
                //当修改成功时，前端页面中的相应开关样式已经发生改变，此时就不用像之前表格追加数据般重新刷新页面，调用findAllUser函数
                console.log('状态修改成功');
            },
            function(error) {
                console.log(error);
            });
    }
});
