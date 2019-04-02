var lsz = new Vue({
    el: "#user",
    data: {
        userList: []
    },
    mounted: function () {
        $.get("/user", {}, function (data) {
            lsz.userList = data;
        }, "JSON");
    },
    methods: {
        lock: function (id) {
            layer.confirm("您确定要锁定这名用户吗？",
                {btn: ["好der", "不了"]}, function () {
                    $.ajax({
                        url: "/user",
                        data: {"id": id},
                        method: 'delete',
                        success: () => {
                            location.reload();
                        }
                    });
                });
        },
        unlock: function (id) {
            layer.confirm("您确定要解锁这名用户吗？",
                {btn: ["好der", "不了"]}, function () {
                    $.ajax({
                        url: "/user/active",
                        data: {"id": id},
                        method: 'put',
                        success: () => {
                            location.reload();
                        }
                    });
                });
        },
        changePassword: function (id, user) {
            layer.prompt({title: "请输入新的密码", formType: 1}, function (pass, index) {
                layer.close(index);
                $.ajax({
                    url: "/user/update",
                    data: {"id": id, "username": user, "password": pass},
                    method: 'put',
                    success: () => {
                        layer.msg("修改密码成功");
                    }
                });
            });
        }
    }
});
$(function () {
    $("#userTable").DataTable({
        language: {url: "js/Chinese.json"},
        aoColumnDefs: [{"bSortable": false, "aTargets": [1, 4]}]
    });
});