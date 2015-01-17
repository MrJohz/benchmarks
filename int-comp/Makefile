all:
	@echo "C version"
	../benchmarker.py -n20 "gcc helloworld.c -ohelloworld && ./helloworld"

	@echo "CPython version"
	../benchmarker.py -n20 'python -c "Hello, World!"'

	@echo "PyPy version"
	../benchmarker.py -n20 'pypy -c "Hello, World!"'
