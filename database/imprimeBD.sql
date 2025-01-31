DECLARE @sql NVARCHAR(MAX) = '';

SELECT @sql = @sql + 
    'SELECT ''' + TABLE_NAME + ''' AS Tabla, * FROM ' + TABLE_NAME + '; ' 
FROM INFORMATION_SCHEMA.TABLES 
WHERE TABLE_TYPE = 'BASE TABLE';

EXEC sp_executesql @sql;
