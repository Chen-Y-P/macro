// import data 
mongoimport --db garden3 --collection order --drop --file data/garden.order.json
mongoimport --db garden3 --collection product --drop --file data/garden.product.json
mongoimport --db garden3 --collection category --drop --file data/garden.category.json
mongoimport --db garden3 --collection review --drop --file data/garden.review.json
mongoimport --db garden3 --collection user --drop --file data/garden.user.json
