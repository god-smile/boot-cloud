
$(function(){
    //根据窗口调整表格高度
    $(window).resize(function() {
        $('#userTable').bootstrapTable('resetView', {
            height: tableHeight()
        })
    });
    console.log("sss");
    // 生成用户数据
    loadData();

    // 渲染复选框
    renderCheckBox();

    /** 加载数据 */
    function loadData() {
        //生成用户数据
        $('#userTable').bootstrapTable({
            method: 'post',
            // contentType: "application/x-www-form-urlencoded",
            // contentType: "application/json; charset=utf-8",
            // url:"/user/queryUserInfoForPage",
            height:tableHeight(),//高度调整
            striped: true, //是否显示行间隔色
            rownumbers:true,
            // dataField: "res",
            pageNumber: 1, //初始化加载第一页，默认第一页
            pagination:true,//是否分页
            paginationPreText: '上一页',
            paginationNextText: '下一页',
            queryParamsType:'limit',
            // queryParams:queryParams,
            sidePagination:'server',
            pageSize:10,//单页记录数
            pageList:[5,10,20,30],//分页步进值
            showRefresh:true,//刷新按钮
            showColumns:true,
            clickToSelect: true,//是否启用点击选中行
            toolbarAlign:'right',
            buttonsAlign:'right',//按钮对齐方式
            // toolbar:'#toolbar',//指定工作栏
            ajax: tableLoadRequest,//自定义ajax加载数据
            columns:[
                {title:'全选',field:'select',checkbox:true,width:25,align:'center',valign:'middle'},
                {title:'id',field:'userId',visible:false},
                {title:'用户名',field:'userName',sortable:true},
                {title:'姓名',field:'realName',sortable:true},
                {title:'邮箱',field:'userEmail'},
                {title:'注册日期',field:'createTime',sortable:true},
                {title:'修改日期',field:'modifyTime',sortable:true},
                {title:'状态',field:'userState',align:'center',formatter:operateFormatter}
            ],
            locale:'zh-CN',//中文支持,
        });
    }

    /**
     * 请求后台数据获取角色列表
     * 渲染复选框
     */
    function renderCheckBox() {
        var user=[];
        //条件查询
        var req= {
            baseRequest:{
                pageNum: 1,
                pageSize: 999
            }
        };

        var userTableAjax= {
            method: 'POST',
            url: "/user/queryUserInfoForPage",
            data: JSON.stringify(req),
            contentType: 'application/json; charset=utf-8',
            dataType:'json',
            success: function(res){
                console.log("res:"+res);
                console.log("code:"+res.code);
                console.log("data:"+res.data);
                if(res.code == "8888"){
                    for(var i=0;i<res.data.dataList.length;i++){
                        var obj=new Object();
                        obj.userId=res.data.dataList[i].userId;
                        obj.userName=res.data.dataList[i].userName;
                        user[i]=obj;
                    }
                    //生成增加与修改页面的角色复选框
                    var _roleHtml='';
                    for(var i=0;i<user.length;i++){
                        _roleHtml+='<label><input type="checkbox" name="userId[]"   value="'+user[i].userId+'"/> '+user[i].userName+' </label>';
                    }
                    $('.role').html(_roleHtml);
                    $('.role input').eq(0).attr('checked','true');
                    //请求成功后生成增加用户页面表单内容
                    $('#addForm').bootstrapValidator({
                        feedbackIcons: {
                            valid: 'glyphicon glyphicon-ok',
                            invalid: 'glyphicon glyphicon-remove',
                            validating: 'glyphicon glyphicon-refresh'
                        },
                        fields: {
                            'userId[]': {
                                validators: {
                                    notEmpty: {
                                        message: '至少选择一条记录'
                                    }
                                }
                            },
                            userName: {
                                validators: {
                                    notEmpty: {
                                        message: '登录名不能为空'
                                    },
                                    stringLength:{
                                        min:5,
                                        max:15,
                                        message:'姓名为5-10位'
                                    }
                                }
                            },
                            realName: {
                                validators: {
                                    notEmpty: {
                                        message: '姓名不能为空'
                                    },
                                    stringLength:{
                                        min:2,
                                        max:10,
                                        message:'姓名为2-10位'
                                    }
                                }
                            },
                            userPassword:{
                                validators:{
                                    notEmpty:{
                                        message:'密码不能为空'
                                    },
                                    stringLength:{
                                        min:6,
                                        max:128,
                                        message:'密码为6-128位'
                                    }
                                }

                            },
                            /*Tel: {
                                validators: {
                                    notEmpty: {
                                        message: '手机号不能为空'
                                    },
                                    stringLength: {
                                        min: 11,
                                        max: 11,
                                        message: '手机号必须为11位'
                                    },
                                    regexp: {
                                        regexp: /^1(3|4|5|7|8)\d{9}$/,
                                        message: '请填写正确的手机号'
                                    }
                                }
                            },*/
                            userEmail: {
                                validators: {
                                    notEmpty:{
                                        message:'邮箱不能为空'
                                    },
                                    regexp: {
                                        regexp:/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/ ,
                                        message: '无效的邮箱'
                                    }
                                }
                            },
                            userState: {
                                validators: {
                                    notEmpty: {
                                        message: '状态不能为空'
                                    }
                                }
                            }
                        }
                    });
                    $('#editForm').bootstrapValidator({
                        feedbackIcons: {
                            valid: 'glyphicon glyphicon-ok',
                            invalid: 'glyphicon glyphicon-remove',
                            validating: 'glyphicon glyphicon-refresh'
                        },
                        fields: {
                            'userId[]': {
                                validators: {
                                    notEmpty: {
                                        message: '至少选择一条记录'
                                    }
                                }
                            },
                            userId:{
                                validators:{
                                    notEmpty: {
                                        message: 'id不能为空'
                                    }
                                }
                            },
                            realName: {
                                validators: {
                                    notEmpty: {
                                        message: '登录名不能为空'
                                    }/*,
		                       stringLength:{
		               			min:5,
		               			max:15,
		               			message:'登录名为5-10位'
		               		}*/
                                }
                            },
                            Name: {
                                validators: {
                                    notEmpty: {
                                        message: '姓名不能为空'
                                    },
                                    stringLength:{
                                        min:2,
                                        max:10,
                                        message:'姓名为2-10位'
                                    }
                                }
                            },
                            /*Tel: {
                                validators: {
                                    notEmpty: {
                                        message: '手机号不能为空'
                                    },
                                    stringLength: {
                                        min: 11,
                                        max: 11,
                                        message: '手机号必须为11位'
                                    },
                                    regexp: {
                                        regexp: /^1(3|4|5|7|8)\d{9}$/,
                                        message: '请填写正确的手机号'
                                    }
                                }
                            },*/
                            userEmail: {
                                validators: {
                                    notEmpty:{
                                        message:'邮箱不能为空'
                                    },
                                    regexp: {
                                        regexp:/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/ ,
                                        message: '无效的邮箱'
                                    }
                                }
                            },
                            userState: {
                                validators: {
                                    notEmpty: {
                                        message: '状态不能为空'
                                    }
                                }
                            }
                        }
                    });
                }else{
                    console.log('后台角色列表获取失败！');
                }
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                if (textStatus == "timeout") {
                    //alert('请求超时，请重试');
                } else {
                    //alert("请求报错")
                    console.log(errorThrown);
                }
            }
        };
        getAjax(userTableAjax);
    }

    function operateFormatter(value,row,index){
        /*if(value==2){
            return '<i class="fa fa-lock" style="color:red"></i>'
        }else if(value==1){
            return '<i class="fa fa-unlock" style="color:green"></i>'
        }else{
            return '数据错误'
        }*/
        if(value=='1'){
            return "正常";
        }else if (value=='2'){
            return "冻结";
        }else if (value=='3') {
            return "删除";
        }else{
            return "其他";
        }
    }

    //请求服务数据时所传参数
    function queryParams(params){
        return{
            pageSize: params.data.limit,
            pageIndex:params.data.pageNumber,
            Name:$('#search_name').val(),
            Tel:$('#search_tel').val()
        }
    }
    //查询按钮事件
    $('#search_btn').click(function(){
        $('#userTable').bootstrapTable('refresh', {url: '/user/queryUserInfoForPage'});
    })

    //增加按钮事件
    $('#btn_add').click(function(){
        $('.tableBody').addClass('animated slideOutLeft');
        setTimeout(function(){
            $('.tableBody').removeClass('animated slideOutLeft').css('display','none');
        },500)
        $('.addBody').css('display','block');
        $('.addBody').addClass('animated slideInRight');
    })
    //删除按钮与修改按钮的出现与消失
    $('.bootstrap-table').change(function(){
        var dataArr=$('#mytab .selected');
        if(dataArr.length==1){
            $('#btn_edit').css('display','block').removeClass('fadeOutRight').addClass('animated fadeInRight');
        }else{
            $('#btn_edit').addClass('fadeOutRight');
            setTimeout(function(){
                $('#btn_edit').css('display','none');
            },400);
        }
        if(dataArr.length>=1){
            $('#btn_delete').css('display','block').removeClass('fadeOutRight').addClass('animated fadeInRight');
        }else{
            $('#btn_delete').addClass('fadeOutRight');
            setTimeout(function(){
                $('#btn_delete').css('display','none');
            },400);
        }
    });
    //修改按钮事件
    $('#btn_edit').click(function(){
        var dataArr=$('#mytab').bootstrapTable('getSelections');
        $('.tableBody').addClass('animated slideOutLeft');
        setTimeout(function(){
            $('.tableBody').removeClass('animated slideOutLeft').css('display','none');
        },500)
        $('.changeBody').css('display','block');
        $('.changeBody').addClass('animated slideInRight');
        $('#edit_ID').val(dataArr[0].ID);
        $('#edit_LoginName').val(dataArr[0].LoginName);
        $('#edit_Name').val(dataArr[0].Name);
        $('#edit_Tel').val(dataArr[0].Tel);
        $('#edit_Email').val(dataArr[0].Email);
        if(dataArr[0].Attribute==1){
            $("#editForm input[name=Attribute]:eq(0)").prop("checked",true);
            $("#editForm input[name=Attribute]:eq(1)").prop("checked",false);
        }
        else if(dataArr[0].Attribute==2){
            $("#editForm input[name=Attribute]:eq(1)").prop("checked",true);
            $("#editForm input[name=Attribute]:eq(0)").prop("checked",false);
        }
        //先清空角色复选框
        $('#editForm .edit input').prop('checked',false);
        //获取用户角色
        $.post('../index.php/admin/Index/getUserById',
            {ID:dataArr[0].ID},
            function(data){
                var roleIDArr=data.res.user.RoleID;
                //将对应用户的角色列表显示到对应的修改页
                for(var i=0;i<roleIDArr.length;i++){
                    for(var j=0;j<$('#editForm .edit input').length;j++){
                        if(roleIDArr[i]==$('#editForm .edit input:eq('+j+')').val()){
                            $('#editForm .edit input:eq('+j+')').prop('checked',true);
                        }
                    }
                }
            }
        );
    })
    /*
     * 用户管理增加用户页面所有事件
    */
    //增加页面表单验证
    // Validate the form manually
    $('#add_saveBtn').click(function() {
        //点击保存时触发表单验证
        $('#addForm').bootstrapValidator('validate');
        //如果表单验证正确，则请求后台添加用户
        if($("#addForm").data('bootstrapValidator').isValid()){
            var _info = $('#addForm').serialize();
            $.post(
                "../index.php/admin/index/insertUser",
                $('#addForm').serialize(),
                function(data){
                    //后台返回添加成功
                    if(data.suc==true){
                        $('.addBody').addClass('animated slideOutLeft');
                        setTimeout(function(){
                            $('.addBody').removeClass('animated slideOutLeft').css('display','none');
                        },500);
                        $('.tableBody').css('display','block').addClass('animated slideInRight');
                        $('#mytab').bootstrapTable('refresh', {url: '../index.php/admin/index/userManagement'});
                        $('#addForm').data('bootstrapValidator').resetForm(true);
                        //隐藏修改与删除按钮
                        $('#btn_delete').css('display','none');
                        $('#btn_edit').css('display','none');
                    }
                    //否则
                    else{
                    }
                }
            )
        }
    });
    //增加页面返回按钮事件
    $('#add_backBtn').click(function() {
        $('.addBody').addClass('animated slideOutLeft');
        setTimeout(function(){
            $('.addBody').removeClass('animated slideOutLeft').css('display','none');
        },500)
        $('.tableBody').css('display','block').addClass('animated slideInRight');
        $('#addForm').data('bootstrapValidator').resetForm(true);
    });
    /*
     * 用户管理修改用户页面所有事件
    */
    //修改页面回退按钮事件
    $('#edit_backBtn').click(function(){
        $('.changeBody').addClass('animated slideOutLeft');
        setTimeout(function(){
            $('.changeBody').removeClass('animated slideOutLeft').css('display','none');
        },500)
        $('.tableBody').css('display','block').addClass('animated slideInRight');
        $('#editForm').data('bootstrapValidator').resetForm(true);
    })
    //修改页面保存按钮事件
    $('#edit_saveBtn').click(function(){
        $('#editForm').bootstrapValidator('validate');
        if($("#editForm").data('bootstrapValidator').isValid()){
            $.post("../index.php/admin/index/updateUserById",
                $('#editForm').serialize(),
                function(data){
                    if(data.suc==true){
                        //隐藏修改与删除按钮
                        $('#btn_delete').css('display','none');
                        $('#btn_edit').css('display','none');
                        //回退到人员管理主页
                        $('.changeBody').addClass('animated slideOutLeft');
                        setTimeout(function(){
                            $('.changeBody').removeClass('animated slideOutLeft').css('display','none');
                        },500)
                        $('.tableBody').css('display','block').addClass('animated slideInRight');
                        //刷新人员管理主页
                        $('#mytab').bootstrapTable('refresh', {url: '../index.php/admin/index/userManagement'});
                        //修改页面表单重置
                        $('#editForm').data('bootstrapValidator').resetForm(true);
                    }else{
                    }
                }
            )
        }
    })
    //删除事件按钮
    $('#btn_delete').click(function(){
        var dataArr=$('#mytab').bootstrapTable('getSelections');
        $('.popup_de .show_msg').text('确定要删除该用户吗?');
        $('.popup_de').addClass('bbox');
        $('.popup_de .btn_submit').one('click',function(){
            var ID=[];
            for(var i=0;i<dataArr.length;i++){
                ID[i]=dataArr[i].ID;
            }
            $.post("../index.php/admin/index/deleteUserById",
                {ID:ID},
                function(data){
                    if(data.suc==true){
                        $('.popup_de .show_msg').text('删除成功！');
                        $('.popup_de .btn_cancel').css('display','none');
                        $('.popup_de').addClass('bbox');
                        $('.popup_de .btn_submit').one('click',function(){
                            $('.popup_de').removeClass('bbox');
                        })
                        $('#mytab').bootstrapTable('refresh', {url: '../index.php/admin/index/userManagement'});
                    }else{
                    }
                });
        })
    })
    //弹出框取消按钮事件
    $('.popup_de .btn_cancel').click(function(){
        $('.popup_de').removeClass('bbox');
    })
    //弹出框关闭按钮事件
    $('.popup_de .popup_close').click(function(){
        $('.popup_de').removeClass('bbox');
    })


    //默认加载
    function tableLoadRequest(params){
        var ps = queryParams(params);
        //设置请求参数
        var pageNum = (params.data.offset/params.data.limit)+1;
        ps['pageNum'] = pageNum;
        ps['pageSize'] = params.data.limit;
        //条件查询
        var req= {
            /*baseRequest:{
                pageNum:pageNum,
                pageSize:params.pageSize.limit
            }*/
            baseRequest:ps/*,
        sysCode:sysComm.sysCode,
        plNos: plNos,
        eqpNo: geomagneticNo,
        berthNo:berthNo,
        eventTypes:eventTypes,
        factoryNos:factoryNos,
        createTime:createTime,
        eqpType:eqpType*/
        };
        var userTableAjax= {
            method: params.type,
            url: "/user/queryUserInfoForPage",
            data: JSON.stringify(req),
            contentType: 'application/json; charset=utf-8',
            dataType:'json',
            success: function(res){
                console.log(res)
                if(res.code = "8888"){
                    params.success(res.data);
                }else{

                }
            }
        };
        getAjax(userTableAjax);
    };
})

function tableHeight() {
    return $(window).height() - 140;
}