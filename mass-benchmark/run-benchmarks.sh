DIRS=$(ls -d */)
EXCLUDES=(java/)

for dir in $DIRS; do
  echo Benchmarking $dir
  if [[ ${EXCLUDES[*]} =~ "$dir" ]]; then
    echo "This benchmark has been excluded (see the blog post for details)"
    echo
    continue
  fi
  cd $dir
  ./setup.sh
  ../../benchmarker.py -n40 ./run.sh
  cd ../
  echo
done
