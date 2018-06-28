var lsz = new Vue({
    el: "#user",
    data: {
        userList: []
    },
    mounted: function () {
        $.post("/user", {"action": "get"}, function (data) {
            lsz.userList = data;
        }, "JSON");
    },
    methods: {
        lock: function (id) {
            layer.confirm("您确定要锁定这名用户吗？",
                {btn: ["好der", "不了"]}, function () {
                    $.post("/user", {"action": "del", "id": id}, function () {
                        location.reload();
                    }, "text");
                });
        },
        unlock: function (id) {
            layer.confirm("您确定要解锁这名用户吗？",
                {btn: ["好der", "不了"]}, function () {
                    $.post("/user", {"action": "act", "id": id}, function () {
                        location.reload();
                    }, "text");
                });
        },
        changePassword: function (id, user) {
            layer.prompt({title: "请输入新的密码", formType: 1}, function (pass, index) {
                layer.close(index);
                $.post("/user", {"action": "update", "id": id, "username": user, "password": pass}, function () {
                    layer.msg("修改密码成功");
                }, "text");
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