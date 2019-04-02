var lsz = new Vue({
    el: "#home",
    data: {
        msgList: []
    },
    mounted: function () {
        $.get("/msg", {}, function (data) {
            lsz.msgList = data;
        }, "JSON");
    },
    methods: {
        del: (id) => {
            layer.confirm("您确定要删掉这条评论吗？",
                {btn: ["好der", "不了"]}, function () {
                    $.ajax({
                        url: "/msg",
                        data: {"id": id},
                        method: 'delete',
                        success: () => {
                            location.reload();
                        }
                    });
                });
        },
        logout: () => {
            $.get("/user/logout", {}, () => location.href = "/", "text");
        }
    }
});
$(function () {
    $("#msgTable").DataTable({
        language: {url: "js/Chinese.json"},
        aoColumnDefs: [{"bSortable": false, "aTargets": [1, 2, 3, 4, 5]}]
    });
});