all:
	@echo "C++ version"
	../benchmarker.py -n20 "g++ helloworld.c -ohelloworld && ./helloworld"

	@echo "CPython version"
	../benchmarker.py -n20 'python -c "print(\"Hello, World\")"'

	@echo "PyPy version"
	../benchmarker.py -n20 'pypy -c "print(\"Hello, World\")"'
