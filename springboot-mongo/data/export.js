// export data via mongoexport
// Only works for collections with simple data that fits the limitations of JSON
mongoexport --db garden2 --collection order --out data/garden.order.json
mongoexport --db garden2 --collection product --out data/garden.product.json
mongoexport --db garden2 --collection category --out data/garden.category.json
mongoexport --db garden2 --collection review --out data/garden.review.json
mongoexport --db garden2 --collection user --out data/garden.user.json