# SKU规格设计

specKey如果不是标准的，那么他就是只属于某个sku

SPU(颜色，尺码，尺寸)

SKU1 SKU2 SKU3

SPU - SPEC_KEY 多对多						  spu_key表

SKU - SPEC_VALUE 多对多的关系 		sku_spec表

SPU-SKU 一对多的关系