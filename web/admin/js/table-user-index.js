var TableManaged = function () {
    return {
        init: function () {
            if (!jQuery().dataTable) {
                return;
            }
            $('#table_user_index').dataTable({
                "aoColumns": [
                  { "bSortable": false },
                  null,
                  null,
                  null,
                  null,
                  null,
                  null,
                  { "bSortable": false }
                ],
                "aLengthMenu": [
                    [10, 50, 100, -1],
                    [10, 50, 100, "全部"] // change per page values here
                ],
                "iDisplayLength": 10,
                "sDom": "<'row-fluid'<'span6'l><'span6'f>r>t<'row-fluid'<'span6'i><'span6'p>>",
                "sPaginationType": "bootstrap",
                "oLanguage": {
                    "sSearch": "搜索:",
                    "sLengthMenu": "每页显示 _MENU_ 条记录",
                    "sZeroRecords": "没有记录",
                    "sInfo": "显示第  _START_ 条到第  _END_ 条记录, 共  _TOTAL_ 条记录",
                    "oPaginate": {
                        "sPrevious": "下一页",
                        "sNext": "上一页"
                    }
                },
                "aoColumnDefs": [{
                        'bSortable': false,
                        'aTargets': [0]
                    }
                ]
            });

            jQuery('#table_user_index .group-checkable').change(function () {
                var set = jQuery(this).attr("data-set");
                var checked = jQuery(this).is(":checked");
                jQuery(set).each(function () {
                    if (checked) {
                        $(this).attr("checked", true);
                    } else {
                        $(this).attr("checked", false);
                    }
                });
                jQuery.uniform.update(set);
            });
        }
    };
}();