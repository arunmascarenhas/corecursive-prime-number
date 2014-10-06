(ns corecursive-prime-number.core)

(def primes
  (lazy-cat [2 3]
            (filter
             (fn [x] (not-any?
                      (fn [y] (zero?
                               (rem x y)))
                      (take-while
                       (partial >= (Math/sqrt x))
                       primes)))
             (iterate (partial + 2)
                      (+ (last primes) 2)))))

