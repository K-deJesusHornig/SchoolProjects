WITH Jsondata AS (SELECT '
    { "value": 3,
    "left": {"value": 1,
             "left":  {"value": 0},
             "right": {"value": 2}},
    "right": {"value": 5,
              "left":  {"value": 4},
              "right": {"value": 6}} }
    ' :: JSONB AS jsondata)

-- You could use jsonb_path_query_array instead
SELECT jsonb_path_query(jsondata,
   'strict $.**'
  ) as BTree
  FROM Jsondata;