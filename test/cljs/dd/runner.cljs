(ns dd.runner
    (:require [doo.runner :refer-macros [doo-tests]]
              [dd.core-test]))

(doo-tests 'dd.core-test)
