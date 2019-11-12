select
    id
    , name
    , mail
    , department_id as departmentId
from
    employee
<#if (id)?has_content>
where
    id = #{id}
</#if>