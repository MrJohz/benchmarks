all:
	@echo "Fast implementation (no whitespace)"
	wc -c fast.c
	gcc -time fast.c

	@echo
	@echo "Slow implementation (some whitespace)"
	wc -c slow.c
	gcc -time slow.c
