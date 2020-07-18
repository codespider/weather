lint:
	lein cljfmt fix
	lein eastwood

migrate:
	lein migrate

rollback:
	lein rollback
